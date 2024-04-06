/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarylaba;

import Books.Book;
import People.User;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author kateshcherbinina
 */
public class LibraryLaba {

    public static void main(String[] args) {

        CreateThings dataInitializer = new CreateThings();
        List<Book> books = dataInitializer.generateBooks();
        List<User> teachers = dataInitializer.generateTeachers(books);
        List<User> students = dataInitializer.generateStudents(books);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI(teachers, students).setVisible(true);
            }
        });
    }
}
