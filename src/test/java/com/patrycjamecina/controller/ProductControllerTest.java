package com.patrycjamecina.controller;
import com.patrycjamecina.model.Mission;
import com.patrycjamecina.model.Product;
import com.patrycjamecina.model.ProductFootprint;
import com.patrycjamecina.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductServiceImpl productService;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void find_Products_By_MissionName_Test() throws Exception {
        Date date = new Date();
        Mission mission = new Mission();
        mission.setMissionName("SpaceRan");
        ProductFootprint productFootprint = new ProductFootprint();
        Product product = new Product(mission, date, productFootprint, 23.6, "www.test.pl");
        List<Product> products = new ArrayList<>();
        products.add(product);
        this.mockMvc.perform(get("/product/find-by-mission-name?name=SpaceRan")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}