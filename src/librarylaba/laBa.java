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
 * @author user
 */
public class laBa extends JFrame {

    public laBa(List<User> students, List<User> teachers) {
        setTitle("Библиотечные записи");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Университет");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты");
        DefaultMutableTreeNode teacherNode = new DefaultMutableTreeNode("Преподы");

        for (User student : students) {
            DefaultMutableTreeNode studentDetailNode = new DefaultMutableTreeNode(student.getFullName());
            for (Book book : student.getBooks()) {
                studentDetailNode.add(new DefaultMutableTreeNode(book.toString()));
            }
            studentNode.add(studentDetailNode);
        }

        for (User teacher : teachers) {
            DefaultMutableTreeNode teacherDetailNode = new DefaultMutableTreeNode(teacher.getFullName());
            for (Book book : teacher.getBooks()) {
                teacherDetailNode.add(new DefaultMutableTreeNode(book.toString()));
            }
            teacherNode.add(teacherDetailNode);
        }

        root.add(studentNode);
        root.add(teacherNode);

        JTree tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);
    }

}
