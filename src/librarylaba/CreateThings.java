/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarylaba;

import Books.Book;
import Books.BookFactory;
import Books.EnglishEducationalFactory;
import Books.EnglishFictionalFactory;
import Books.RussianEducationalFactory;
import Books.RussianFictionalFactory;
import People.Director;
import People.StudentBuilder;
import People.TeacherBuilder;
import People.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kateShcherbinina
 */
public class CreateThings {

    public CreateThings() {
    }

    protected List<User> generateStudents(List<Book> books) {
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

    protected List<User> generateTeachers(List<Book> books) {
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

    protected List<Book> generateBooks() {
        BookFactory russianEdFactory = new RussianEducationalFactory();
        BookFactory englishEdFactory = new EnglishEducationalFactory();
        BookFactory englishFicFactory = new EnglishFictionalFactory();
        BookFactory russianFicFactory = new RussianFictionalFactory();

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            books.add(russianEdFactory.createBook());
        }
        for (int i = 0; i < 50; i++) {
            books.add(englishEdFactory.createBook());
        }
        for (int i = 0; i < 60; i++) {
            books.add(russianFicFactory.createBook());
        }
        for (int i = 0; i < 60; i++) {
            books.add(englishFicFactory.createBook());
        }
        return books;

    }

}
