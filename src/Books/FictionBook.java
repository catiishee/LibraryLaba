/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

/**
 *
 * @author kateshcherbinina
 */
public class FictionBook extends Book {

    private String author;

    public FictionBook(String title, String language) {
        super(title, language);
        author = null;
    }

    public FictionBook(String title, String language,String author) {
        super(title, language);
        this.author = author;
    }

    @Override
    public String toString() {
        if(author != null){
            return title + " - " + author;
        }
        else{
            return title;
        }
    }
    
    

}
