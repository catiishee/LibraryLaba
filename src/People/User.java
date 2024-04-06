/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

import Books.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kateshcherbininaà
 */
public class User {

    private String fullName;
    private List<Book> books = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" + "fullName=" + fullName + ", books=" + books + '}';
    }

}
