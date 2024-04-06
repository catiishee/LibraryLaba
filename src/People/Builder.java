/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

import Books.Book;
import java.util.List;

/**
 *
 * @author kateshcherbinina
 */
public interface Builder {

    Builder setFullName(String fullName);

    User build();

    Builder createFullName();

    Builder setBooks(List<Book> books);
}
