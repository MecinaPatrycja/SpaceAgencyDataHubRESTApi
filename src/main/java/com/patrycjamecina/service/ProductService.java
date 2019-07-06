package com.patrycjamecina.service;
import com.patrycjamecina.exceptions.ResourceNotFoundException;
import com.patrycjamecina.model.Product;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
public interface ProductService {
    Product addProduct(final Product product) throws Exception;
    void removeProduct(final Long id);
    Product getProduct(Long id) throws ResourceNotFoundException;
    List<Product> getAllProducts();
    List<Product> findProductsByMissionName(final String missionName);
    List<Product> findProductsByProductType(final String productType);
    List<Product> findProductsMadeBeforeSpecificDate(final String date) throws ParseException;
    List<Product> findProductsMadeAfterSpecificDate(final String date) throws ParseException;
    List<Product> findProductsMadeBetween2SpecificDates(final String date1, final String date2) throws ParseException;
}
