/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

import Books.Book;
import java.util.List;

/**
 *
 * @author user
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }
    
    public User createUser(List<Book> books){
        return  builder.createFullName().setBooks(books).build();
    }
}
