package com.example.factory.factories;

import com.example.factory.documents.Document;

public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}