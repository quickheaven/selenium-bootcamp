package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    public static List<String[]> get(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String row;
            while ((row = br.readLine()) != null) {
                String[] line = row.split(",");
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read " + fileName);
        }
        return data;
    }
}
