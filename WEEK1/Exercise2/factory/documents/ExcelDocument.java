package com.example.factory.documents;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel spreadsheet (.xlsx)...");
    }
}