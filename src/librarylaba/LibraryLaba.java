/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarylaba;

import Books.Book;
import Books.BookFactory;
import Books.EnglishTextbookFactory;
import Books.RussianTextbookFactory;
import People.Director;
import People.StudentBuilder;
import People.TeacherBuilder;
import People.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class LibraryLaba {

    public static void main(String[] args) {

        LibraryLaba laba = new LibraryLaba();

        List<Book> books = laba.generateBooks();
        List<User> teachers = laba.generateTeachers(books);
        List<User> students = laba.generateStudents(books);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI(students, teachers).setVisible(true);
            }
        });
    }

    private List<User> generateStudents(List<Book> books) {
        Random random = new Random();
        List<User> students = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<Book> studentBooks = new ArrayList<>();
            for (int j = 0; j < random.nextInt(8) + 3; j++) {
                studentBooks.add(books.get(random.nextInt(books.size())));
            }
            students.add(new Director(new StudentBuilder()).createUser(studentBooks));
        }
        return students;

    }

    private List<User> generateTeachers(List<Book> books) {
        Random random = new Random();
        List<User> teachers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<Book> teacherBooks = new ArrayList<>();
            for (int j = 0; j < random.nextInt(8) + 3; j++) {
                teacherBooks.add(books.get(random.nextInt(books.size())));
            }
            teachers.add(new Director(new TeacherBuilder()).createUser(teacherBooks));
        }
        return teachers;

    }

    private List<Book> generateBooks() {
        BookFactory russianFactory = new RussianTextbookFactory();
        BookFactory englishFactory = new EnglishTextbookFactory();
        Random random = new Random();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            books.add(russianFactory.createEducationalBook());
        }
        for (int i = 0; i < 50; i++) {
            books.add(englishFactory.createEducationalBook());
        }
        for (int i = 0; i < 60; i++) {
            books.add(russianFactory.createFictionalBook());
        }
        for (int i = 0; i < 60; i++) {
            books.add(englishFactory.createFictionalBook());
        }
        return books;

    }
}
