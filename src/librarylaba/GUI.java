/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarylaba;

import Books.Book;
import People.User;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author kateshcherbinina
 */
public class GUI extends JFrame {

    public GUI(List<User> teachers,List<User> students) {
        setTitle("Библиотечные записи");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        CreateThings dataInitializer = new CreateThings();
//        List<Book> books = dataInitializer.generateBooks();
//        List<User> teachers = dataInitializer.generateTeachers(books);
//        List<User> students = dataInitializer.generateStudents(books);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Университет");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты");
        DefaultMutableTreeNode teacherNode = new DefaultMutableTreeNode("Преподы");

        addStaffForTree(studentNode, students);
        addStaffForTree(teacherNode, teachers);

        root.add(studentNode);
        root.add(teacherNode);

        JTree tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addStaffForTree(DefaultMutableTreeNode parentNode, List<User> users) {
        for (User user : users) {
            DefaultMutableTreeNode userDetailNode = new DefaultMutableTreeNode(user.getFullName());
            for (Book book : user.getBooks()) {
                userDetailNode.add(new DefaultMutableTreeNode(book.toString()));
            }
            parentNode.add(userDetailNode);
        }
    }

}
