package com.example.factory.factories;

import com.example.factory.documents.Document;
import com.example.factory.documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}