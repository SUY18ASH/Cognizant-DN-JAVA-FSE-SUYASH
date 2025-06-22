package com.example.factory;

import com.example.factory.factories.DocumentFactory;
import com.example.factory.factories.WordDocumentFactory;
import com.example.factory.factories.PdfDocumentFactory;
import com.example.factory.factories.ExcelDocumentFactory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // Client uses factories to create/open documents without coupling to concrete classes:
        testFactory(new WordDocumentFactory());
        testFactory(new PdfDocumentFactory());
        testFactory(new ExcelDocumentFactory());
    }

    private static void testFactory(DocumentFactory factory) {
        System.out.println("=== Using " + factory.getClass().getSimpleName() + " ===");
        factory.openDocument();
        System.out.println();
    }
}
