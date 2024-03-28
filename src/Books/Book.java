/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

/**
 *
 * @author user
 */
public abstract class Book {

    protected String title;
    protected String language;

    public Book(String title, String language) {
        this.title = title;
        this.language = language;
    }

    @Override
    public String toString() {
        return title;
    }

}
