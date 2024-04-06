/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

/**
 *
 * @author kateshcherbinina
 */
class EnglishTextbook extends Book {

    private String level;
    private String author;
    private String university;

    public EnglishTextbook(String title, String level, String author, String university) {
        super(title, "English");
        this.level = level;
        this.author = author;
        this.university = university;
    }

    @Override
    public String toString() {
        return super.title + " (" + level + ") " + author + " - " + university;
    }

}
