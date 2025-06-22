package com.example.search;

import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] catalog = {
                new Product(101, "Wireless Mouse", "Electronics"),
                new Product(102, "Water Bottle", "Home & Kitchen"),
                new Product(103, "Wired Keyboard", "Electronics"),
                new Product(104, "Wall Clock", "Home Decor"),
                new Product(105, "Wireless Charger", "Electronics")
        };

        // --- Linear Search Demo ---
        System.out.println("=== Linear Search ===");
        String[] queries = {"wireless", "clock", "smartphone"};
        for (String q : queries) {
            Product result = SearchEngine.linearSearch(catalog, q);
            System.out.printf("Query \"%s\": %s%n", q,
                    result != null ? result : "No match found");
        }

        // --- Prepare for Binary Search ---
        Product[] sortedCatalog = Arrays.copyOf(catalog, catalog.length);
        SearchEngine.sortByName(sortedCatalog);
        System.out.println("\nCatalog sorted by name:");
        Arrays.stream(sortedCatalog).forEach(System.out::println);

        // --- Binary Search Demo (exact-name match) ---
        System.out.println("\n=== Binary Search ===");
        String[] exactQueries = {"Wireless Charger", "Wall Clock", "Notebook"};
        for (String q : exactQueries) {
            Product result = SearchEngine.binarySearch(sortedCatalog, q);
            System.out.printf("Query \"%s\": %s%n", q,
                    result != null ? result : "No exact match found");
        }
    }
}