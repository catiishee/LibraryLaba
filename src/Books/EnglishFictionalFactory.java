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
public class EnglishFictionalFactory implements FictionalBookFactory {
    
    List<String> authors = CsvLoader.loadFromCSV("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\english_literature_authors.csv");

    @Override
    public Book createBook() {
        String csvFilePath = "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\adjectives_nouns.csv";
        String title = generateTitleFromCSV(csvFilePath);
        String author = authors.get(new Random().nextInt(authors.size()));
        return new FictionBook(title, "English",author);
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
}
