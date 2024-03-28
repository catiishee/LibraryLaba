/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

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
public class NameGenarator {
    
    public String generateFullName() {
        try {
            Random random = new Random();
            int option = random.nextInt(2);
            String nameFile = option == 0 ? "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\createFullName3.csv" : "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\createFullName2.csv";
            String surnameFile = option == 0 ? "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\createFullName1.csv" : "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\createFullName4.csv";

            List<String> names = loadFromCSV(nameFile);
            List<String> surnames = loadFromCSV(surnameFile);
            String name = names.get(random.nextInt(names.size()));
            String surname = surnames.get(random.nextInt(surnames.size()));
            return surname + " " + name;
        } catch (IOException ex) {
            Logger.getLogger(NameGenarator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public String generateFullNameTeacher() {
        try {
            Random random = new Random();
            int option = random.nextInt(2);
            String nameFile = option == 0 ? "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\createFullName3.csv" : "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\createFullName2.csv";
            String surnameFile = option == 0 ? "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\фамилии преподов мужские.csv" : "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\фамилии преподов женские.csv";
            String patronymicFile = option == 0 ? "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\patronymics.csv" : "C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\feminine_patronymics.csv";

            List<String> names = loadFromCSV(nameFile);
            List<String> surnames = loadFromCSV(surnameFile);
            List<String> patronymics = loadFromCSV(patronymicFile);
            String name = names.get(random.nextInt(names.size()));
            String surname = surnames.get(random.nextInt(surnames.size()));
            String patronymic = patronymics.get(random.nextInt(patronymics.size()));
            return surname + " " + name + " " + patronymic;
        } catch (IOException ex) {
            Logger.getLogger(NameGenarator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
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
