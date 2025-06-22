package com.example.search;

import java.util.Arrays;

public class SearchEngine {

    public static Product linearSearch(Product[] products, String query) {
        String q = query.toLowerCase();
        for (Product p : products) {
            if (p.getProductName().toLowerCase().contains(q)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String query) {
        int low = 0, high = sortedProducts.length - 1;
        String q = query.toLowerCase();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            String midName = sortedProducts[mid].getProductName().toLowerCase();
            int cmp = midName.compareTo(q);
            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void sortByName(Product[] products) {
        Arrays.sort(products);
    }
}