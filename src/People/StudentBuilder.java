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
public class StudentBuilder implements Builder {
    
    private User user = new User();
    
    @Override
    public User build() {
        return user;
    }
    
    @Override
    public Builder setFullName(String fullName) {
        user.setFullName(fullName);
        return this;
    }
    
    @Override
    public Builder createFullName() {
        user.setFullName(new NameGenarator().generateFullNameStudent());
        
        return this;
        
    }
    
    @Override
    public Builder setBooks(List<Book> books) {
        user.setBooks(books);
        return this;
    }
    
}
