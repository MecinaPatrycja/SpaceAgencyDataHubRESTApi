# Space Agency Data Hub REST API
> Space agencies store their satellites images (products) in large data hubs. 
Product Content Administrator manages satellites missions and products of the data hub. 
Customers can search and order products. 

## Port
Application run on an embedded Tomcat via port 8880.

## Security
Application is secured with Basic Authentication. Two roles are defined:
*	Content Manager - able to manage missions and products
  -	Login: admin
  -	Password: admin
*	Customer - able to search and order products
  -	Login: user
  -	Password: user

## Database
Application is connected with in-memory database H2. 
Data source URL is: jdbc:h2:tcp://localhost/~/space. Default username is 'sa' and there is no password.
Database recreates every time application is launched (it is for testing purpose).

## Available (example) queries
*	To add mission:
  -	URL: http://localhost:8880/mission/add 
  -	HTTP method: POST
  -	Example request body (pay attention to the date format): 
{
    "missionName": "TestMission",
    "missionStartDate": "2019-01-01",
    "missionFinishDate": "2019-06-01",
    "imageryType": "Multispectral"
}
		
*	To remove mission:
  -	URL: http://localhost:8880/mission/remove?name=Alpha 
  -	HTTP method: DELETE


*	To update mission (you can not update mission name, because it is primary key) : 
  -	http://localhost:8880/mission/edit?name=Job 
  -	HTTP method: PUT
  -	Example request body:
 
{
    "missionStartDate": "2017-01-09",
    "missionFinishDate": "2018-04-18",
    "imageryType": "Hyperspectral"
}

*	To add new product (I has to be connected with existing mission):
  -	URL: http://localhost:8880/product/add 
  -	HTTP method: POST
  -	Example request body:
{
    "mission": {
        "missionName": "Asoka"
    },
	"productAcquisitionDate": "2019-04-23",
	"productFootprint": {
		"point1": {
			"lat": "21.45",
			"lng": "-45.76"
		},
		"point2": {
			"lat": "43.65",
			"lng": "76.34"
		},
		"point3": {
			"lat": "87.45",
			"lng": "13.45"
		},
		"point4": {
			"lat": "-65.76",
			"lng": "55.99"
		}
	},
	"productPrice": 203.99,
	"productUrl": "www.test.pl"
}

*	To remove product:
  -	URL: http://localhost:8880/product/remove?id=5  
  -	HTTP method: DELETE

*	To find product by mission name:
  -	URL: http://localhost:8880/product/find-by-mission-name?name=Alpha 
  -	HTTP method: GET

*	To find product by type:
  -	URL: http://localhost:8880/product/find-by-type?type=Hyperspectral 
  -	HTTP method: GET

*	To find product by acquisition date (before date):
  -	URL: http://localhost:8880/product/find-products-before-date?date=01-02-2017 
  -	HTTP method: GET

*	To find product by acquisition date (after date):
  -	URL: http://localhost:8880/product/find-products-after-date?date=01-02-2017 
  -	HTTP method: GET

*	To find product by acquisition date (between two dates):
  -	URL: http://localhost:8880/product/find-products-between-dates?date1=01-02-2017&date2=09-02-2017 
  -	HTTP method: GET

*	To create order:
  -	URL: http://localhost:8880/order/prepare 
  -	HTTP method: POST
  -	HTTP request body:
{
	"orderLineItems" : [
		{
			"quantity": 3,
			"productId": 56
		},
		{
			"quantity": 2,
			"productId": 6
		}
	]
}

*	To get order history: 
  -	URL: http://localhost:8880/order/history 
  -	HTTP method: GET

## Technologies
* Java 8
* Maven 
* SpringBoot 
* Hibernate
* H2



