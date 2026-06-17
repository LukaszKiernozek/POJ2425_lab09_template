package main.java.com.example.cache;

import main.java.com.example.model.DictionaryValue;
import main.java.com.example.readers.DictionaryFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryCache {
    private static DictionaryCache instance;
    private List<DictionaryValue> data = new ArrayList<>();

    private DictionaryCache() {
    }

    public static synchronized DictionaryCache getInstance() {
        if (instance == null) {
            instance = new DictionaryCache();
        }
        return instance;
    }

    public synchronized void setItems(List<DictionaryValue> items) {
        this.data = items;
    }

    public synchronized List<DictionaryValue> getItems() {
        return data;
    }


    public synchronized List<DictionaryValue> getByEnumerationName(String enumName) {
        List<DictionaryValue> result = new ArrayList<>();
        for (DictionaryValue dv : data) {
            if (dv.getEnumName().equals(enumName)) {
                result.add(dv);
            }
        }
        return result;
    }
}