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

/**
 *
 * @author user
 */
public class EnglishTextbookFactory implements BookFactory {

    public Book createEducationalBook() {
        try {
            Random random = new Random();
            List<String> titles = loadFromCSV("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\англИмена.csv");
            List<String> universities = loadFromCSV("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\англУники.csv");
            List<String> authors = loadFromCSV("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\англАвторы.csv");
            String title = titles.get(random.nextInt(titles.size()));
            String university = universities.get(random.nextInt(universities.size()));
            String author = authors.get(random.nextInt(authors.size()));
            String level = new Random().nextBoolean() ? "bachelors" : "magistracy";
            return new EnglishTextbook(title, level, author, university);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(RussianTextbookFactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Book createFictionalBook() {
        String csvFilePath = "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\adjectives_nouns.csv";
        String title = generateTitleFromCSV(csvFilePath);
        return new FictionBook(title, "English");
    }

    private String generateTitleFromCSV(String csvFilePath) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
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
            return randomWord1 + " " + randomWord2;
        } else {
            return "Default Title";
        }
    }

    private static List<String> loadFromCSV(String fileName) throws IOException {
        List<String> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    records.add(line.split(",")[0]);
                }
            }
        }
        return records;
    }
}
