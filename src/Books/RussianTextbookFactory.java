/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RussianTextbookFactory implements BookFactory {

    @Override
    public Book createEducationalBook() {
        try {
            Random random = new Random();
            List<String> titels = loadFromCSV("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\Русскоязычная литература.csv");
            List<String> types = new ArrayList<>(List.of("Учебник", "Пособие", "Задачник"));
            String title = types.get(random.nextInt(types.size())) + " по " + titels.get(random.nextInt(titels.size()));
            return new RussianTextbook(title);
        } catch (IOException ex) {
            Logger.getLogger(RussianTextbookFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Book createFictionalBook() {
        String csvFilePath = "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\fiction.csv";
        String title = generateTitleFromCSV(csvFilePath);
        return new FictionBook(title, "Русский");
    }

    private String generateTitleFromCSV(String csvFilePath) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    lines.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error in reading CSV";
        }

        if (lines.size() > 1) {
            Random random = new Random();

            String randomWord1 = lines.get(random.nextInt(lines.size()))[0];
            String randomWord2 = lines.get(random.nextInt(lines.size()))[1];
            String randomWord3 = lines.get(random.nextInt(lines.size()))[2];
            return randomWord1 + " " + randomWord2 + " " + randomWord3;
        } else {
            return "Default Title";
        }
    }
    
        private static List<String> loadFromCSV(String fileName) throws IOException {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    records.add(line.split(",")[0]);
                }
            }
        }
        return records;
    }

}
