package uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
private static CSVReader instance;
        private CSVReader() {}

        public static CSVReader getInstance() {
            if (instance == null) {
                instance = new CSVReader();
            }
            return instance;
        }
    
        public List<String[]> leerCSV(String archivo) {
            List<String[]> datos = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    datos.add(linea.split(","));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datos;
        }
}
