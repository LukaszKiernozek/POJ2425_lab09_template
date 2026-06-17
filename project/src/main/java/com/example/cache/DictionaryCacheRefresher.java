package main.java.com.example.cache;

import main.java.com.example.model.DictionaryValue;
import main.java.com.example.readers.DictionaryFileReader;

import java.util.List;

public class DictionaryCacheRefresher extends Thread {
    private final String filePath = "src/main/resources/dictionaries.csv";
    private volatile boolean running = true;

    @Override
    public void run() {
        DictionaryFileReader reader = new DictionaryFileReader(filePath);
        while (running) {
            List<DictionaryValue> values = reader.getDictionaryValues();
            DictionaryCache.getInstance().setItems(values);

            System.out.println("Cache odswiezony, liczba rekordow: " + values.size());
            for (DictionaryValue dv : values) {
                System.out.println(dv.getStringKey() + " - " + dv.getValue());
            }

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    public void stopRefreshing() {
        running = false;
        this.interrupt();
    }
}