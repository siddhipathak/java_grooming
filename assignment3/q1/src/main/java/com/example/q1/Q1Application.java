package com.example.q1;

import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.q1.enums.Category;
import com.example.q1.model.Product;
import com.example.q1.utility.Utility;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) {
		try {
			List<Product> products = List.of(
					new Product("1", "iPhone", true, Category.MOBILE),
					new Product("2", "Samsung", false, Category.MOBILE),
					new Product("3", "Lenovo", true, Category.LAPTOP),
					new Product("4", "HP", false, Category.LAPTOP),
					new Product("5", "Samsung", true, Category.TV),
					new Product("6", "Sony", false, Category.TV),
					new Product("7", "Sony", true, Category.REFRIGERATOR),
					new Product("8", "Samsung", false, Category.REFRIGERATOR));
			Category category = Category.MOBILE;
			List<List<Product>> result = Utility.findItem(products, category);

			System.out.println("Product with warranty are:");
			System.out.println(result.get(0));
			System.out.println("Product without warranty are:");
			System.out.println(result.get(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
