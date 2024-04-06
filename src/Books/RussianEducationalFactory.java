/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kateshcherbinina
 */
public class RussianEducationalFactory implements EducationalBookFactory {

    List<String> titels = CsvLoader.loadFromCSV("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\LibraryLaba\\src\\People\\Русскоязычная литература.csv");
    List<String> types = new ArrayList<>(List.of("Учебник", "Пособие", "Задачник"));

    @Override
    public Book createBook() {
        Random random = new Random();
        String title = types.get(random.nextInt(types.size())) + " по " + titels.get(random.nextInt(titels.size()));
        return new RussianTextbook(title);

    }

}
