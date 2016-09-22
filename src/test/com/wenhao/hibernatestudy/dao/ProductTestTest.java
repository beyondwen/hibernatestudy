package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class ProductTestTest {
    @Test
    public void save() throws Exception {
        ProductTest productTest = new ProductTest();
        Product product = new Product();
        product.setName("dfsfsd");
        product.setPassword("12345");
        productTest.save(product);
        // productTest.save();
    }

}