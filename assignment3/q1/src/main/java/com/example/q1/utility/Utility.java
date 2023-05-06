package com.example.q1.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.q1.enums.Category;
import com.example.q1.exception.CategoryNotFoundException;
import com.example.q1.model.Product;

public class Utility {

    public static List<List<Product>> findItem(List<Product> products, Category category) {
        List<List<Product>> itemList = new ArrayList<>();

        Predicate<Product> categoryFilter = product -> product.getCategory().equals(category);
        Predicate<Product> warrantyFilter = product -> product.getWarranty().equals(true);

        List<Product> withWarrantyList = products.stream().filter(categoryFilter.and(warrantyFilter))
                .collect(Collectors.toList());
        List<Product> withoutWarrantyList = products.stream().filter(categoryFilter.and(warrantyFilter.negate()))
                .collect(Collectors.toList());
        itemList.add(withWarrantyList);
        itemList.add(withoutWarrantyList);
        return itemList;
    }

    public static Category findByName (String inputCategory) {
            for(Category c: Category.values())
            {
                if (c.name().equalsIgnoreCase(inputCategory)) {
                    return Category.valueOf(inputCategory.toUpperCase());
                }
            }
            throw new CategoryNotFoundException("Category "+ inputCategory +" not found !");
    }
}
