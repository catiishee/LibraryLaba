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

    private String csvFilePath = "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\англ.csv";

    @Override
    public Book createEducationalBook() {
        String[] bookData = generateBookDataFromCSV();
        if (bookData != null) {
            String discipline = bookData[0];
            String author = bookData[1];
            String university = bookData[2];
            String level = new Random().nextBoolean() ? "bachelors" : "magistracy";
            return new EnglishTextbook(discipline, level, author, university);
        } else {
            return null;
        }
    }

    @Override
    public Book createFictionalBook() {
        String csvFilePath = "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\adjectives_nouns.csv";
        String title = generateTitleFromCSV(csvFilePath);
        return new FictionBook(title, "English");
    }

    private String[] generateBookDataFromCSV() {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    lines.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (!lines.isEmpty()) {
            String[] data = new String[3];
            data[0] = lines.get(new Random().nextInt(lines.size()))[0];
            data[1] = lines.get(new Random().nextInt(lines.size()))[1];
            data[2] = lines.get(new Random().nextInt(lines.size()))[2];
            return data;
        } else {
            return null;
        }
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
