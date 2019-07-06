package com.patrycjamecina.service.impl;
import com.patrycjamecina.exceptions.ResourceNotFoundException;
import com.patrycjamecina.model.Mission;
import com.patrycjamecina.model.Product;
import com.patrycjamecina.repository.MissionRepository;
import com.patrycjamecina.repository.ProductRepository;
import com.patrycjamecina.service.ProductService;
import com.patrycjamecina.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MissionRepository missionRepository;

    @Override
    public Product addProduct(Product product) throws Exception {
        List<Mission> mission = missionRepository.findAll(Example.of(product.getMission()));
        if (mission.isEmpty()) {
            throw new Exception("You must enter existing mission name");
        }
        product.getProductFootprint().getPoint1().setProductFootprint(product.getProductFootprint());
        product.getProductFootprint().getPoint2().setProductFootprint(product.getProductFootprint());
        product.getProductFootprint().getPoint3().setProductFootprint(product.getProductFootprint());
        product.getProductFootprint().getPoint4().setProductFootprint(product.getProductFootprint());
        product.getProductFootprint().setProduct(product);
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductsByMissionName(String missionName) {
        Validator.validateName(missionName);
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getMission().getMissionName().equals(missionName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByProductType(String productType) {
        Validator.validateType(productType);
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getMission().getImageryType().equals(productType))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsMadeBeforeSpecificDate(String strDate) throws ParseException {
        Date date = convertStringToDate(strDate);
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getProductAcquisitionDate().before(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsMadeAfterSpecificDate(String strDate) throws ParseException {
        Date date = convertStringToDate(strDate);
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getProductAcquisitionDate().after(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsMadeBetween2SpecificDates(String strDate1, String strDate2) throws ParseException {
        Date firstDate = convertStringToDate(strDate1);
        Date secondDate = convertStringToDate(strDate2);
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getProductAcquisitionDate().after(firstDate))
                .filter(product -> product.getProductAcquisitionDate().before(secondDate))
                .collect(Collectors.toList());
    }

    static Date convertStringToDate(String dateInString) throws ParseException {
        Date date = DateUtils.parseDate(dateInString,
                new String[] { "yyyy-MM-dd HH:mm:ss", "dd-MM-yyyy" });
        return date;
    }
}
