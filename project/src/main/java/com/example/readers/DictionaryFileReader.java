package main.java.com.example.readers;
import main.java.com.example.model.DictionaryValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryFileReader {
    private final String filePath;

    public DictionaryFileReader(String filePath){
        this.filePath = filePath;
    }

    public String getRawFileData() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                result += line + "\n";
            }
            return result;
        }

    }
    public List<DictionaryValue> parseData(String rawData) {
        List<DictionaryValue> values = new ArrayList<>();
        String[] lines = rawData.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].isBlank()) continue;
            String[] parts = lines[i].split(",");
            int id = Integer.parseInt(parts[0]);
            int intKey = Integer.parseInt(parts[1]);
            String stringKey = parts[2];
            String value = parts[3];
            String enumName = parts[4];
            values.add(new DictionaryValue(id, intKey, stringKey, enumName, value));
        }
        return values;

    }
    public List<DictionaryValue> getDictionaryValues() {
        try {
            String rawData = getRawFileData();
            return parseData(rawData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
