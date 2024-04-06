/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

import java.util.List;
import java.util.Random;

/**
 *
 * @author kateshcherbinina
 */
public class EnglishEducationalFactory implements EducationalBookFactory {

    List<String> titles = CsvLoader.loadFromCSV("C:\\Users\\user\\OneDrive\\ƒокументы\\NetBeansProjects\\LibraryLaba\\src\\People\\англ»мена.csv");
    List<String> universities = CsvLoader.loadFromCSV("C:\\Users\\user\\OneDrive\\ƒокументы\\NetBeansProjects\\LibraryLaba\\src\\People\\англ”ники.csv");
    List<String> authors = CsvLoader.loadFromCSV("C:\\Users\\user\\OneDrive\\ƒокументы\\NetBeansProjects\\LibraryLaba\\src\\People\\англјвторы.csv");

    @Override
    public Book createBook() {
        Random random = new Random();
        String title = titles.get(random.nextInt(titles.size()));
        String university = universities.get(random.nextInt(universities.size()));
        String author = authors.get(random.nextInt(authors.size()));
        String level = new Random().nextBoolean() ? "bachelors" : "magistracy";
        return new EnglishTextbook(title, level, author, university);

    }

}
