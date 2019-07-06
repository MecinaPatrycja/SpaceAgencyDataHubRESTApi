package com.patrycjamecina.controller;
import com.patrycjamecina.exceptions.ResourceNotFoundException;
import com.patrycjamecina.model.Product;
import com.patrycjamecina.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("/add")
    public Product saveProduct(@RequestBody final Product product) throws Exception {
        return productService.addProduct(product);
    }

    @DeleteMapping("/remove")
    public void removeProduct(final Long id) {
        productService.removeProduct(id);
    }

    @GetMapping("/get-by-id/")
    public Product getProduct(Long id) throws ResourceNotFoundException {
        return productService.getProduct(id);
    }

    @GetMapping({"", "/"})
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/find-by-mission-name")
    public List<Product> findProductByMissionName(String name) {
        return productService.findProductsByMissionName(name);
    }

    @GetMapping("/find-by-type")
    public List<Product> findProductByProductType(String type) {
        return productService.findProductsByProductType(type);
    }

    @GetMapping("/find-products-before-date")
    public List<Product> findProductByProductAcquisitionDateBefore(String date) throws ParseException {
        return productService.findProductsMadeBeforeSpecificDate(date);
    }

    @GetMapping("/find-products-after-date")
    public List<Product> findProductByProductAcquisitionDateAfter(String date) throws ParseException {
        return productService.findProductsMadeAfterSpecificDate(date);
    }

    @GetMapping("/find-products-between-dates")
    public List<Product> findProductByProductAcquisitionDateBeetween(String date1, String date2) throws ParseException {
        return productService.findProductsMadeBetween2SpecificDates(date1, date2);
    }
}
