package demo;

import util.Csv;
import util.Excel;

import java.util.List;

public class DataReaders {

    public static void main(String[] args) {
        readCSV();
        readXLS();
    }

    private static void readCSV() {
        String fileName = "src/test/resources/UserAccounts.csv";
        List<String[]> records = Csv.get(fileName);
        for (String[] record : records) {
            for (String field : record) {
                System.out.println(field);
            }
        }
    }

    private static void readXLS() {
        String fileName = "src/test/resources/UserLogin.xls";
        String[][] data = Excel.get(fileName);
        for (String[] record : data) {
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
    }
}
