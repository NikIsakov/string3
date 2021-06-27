package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Товар 1", 100));
        products.add(new Product(2, "Товар 2", 200));
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);//выдает список товаров
    }

    public void add(Product product){
        products.add(product);
    }

    public void remove(Product product){
        products.remove(product);
    }

    public void deleteById(int id) {
        products.remove(products.get(id));
    }

    public void read(int id){
        products.get(id).toString();
    }

    public void changeId(List<Product> products, int id, int newId){//получение товара по id
        Product product = products.get(id);
        product.setId(newId);
    }

    public void changeTitle(List<Product> products, int id, String newTitle){
        Product product = products.get(id);
        product.setTitle(newTitle);
    }

    public void changeCost(List<Product> products, int id, float newCost){
        Product product = products.get(id);
        product.setCost(newCost);
    }

}
