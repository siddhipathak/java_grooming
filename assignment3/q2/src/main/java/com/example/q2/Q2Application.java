package com.example.q2;

import java.util.concurrent.ForkJoinPool;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.q2.utility.CountInstance;

@SpringBootApplication
public class Q2Application {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountInstance countInstance = new CountInstance(9, 1, 1000);
		int result = forkJoinPool.invoke(countInstance);
		System.out.println("There are " + result + " ocurences of 9");
	}

}
