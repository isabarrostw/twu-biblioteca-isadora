package com.twu.biblioteca.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {

    private String[] bookTableColumns = {"Title", "Author(s)", "Year"};
    private Object[][] books = {{"Java Head First", "Bert Bates, Kathy Sierra", "2003"},
            {"Test-Driven Development by Example", "Kent Beck", "2003"},
            {"The Agile Samurai","Jonathan Rasmusson" ,"2010"}};
    private JTable bookTable;
    private JScrollPane bookTableScrollPane;

    public WelcomeFrame() {
        setSize(600,400);
        setLocation(400,200);
        initializeComponents();
        setVisible(true);
    }

    public void initializeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to Bangalore Public Library!", JLabel.CENTER);
        add(welcomeLabel);
        initializeMenu();
    }

    public void showBooksTable() {
        bookTable = new JTable(books, bookTableColumns);
        bookTableScrollPane = new JScrollPane(bookTable);

        bookTable.setFillsViewportHeight(true);
        createBooksFrame().add(bookTableScrollPane);
    }

    public JFrame createBooksFrame() {
        JFrame booksFrame = new JFrame();
        booksFrame.setSize(500,200);
        booksFrame.setLocation(450,250);
        booksFrame.setVisible(true);

        return booksFrame;
    }

    public void initializeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuListBooks = new JMenu("List Books");
        JMenuItem menuAll = new JMenuItem("All");
        JMenuItem menuQuit = new JMenuItem("Quit");

        menuAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBooksTable();
            }
        });

        menuQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuListBooks.add(menuAll);
        menuListBooks.add(menuQuit);
        menuBar.add(menuListBooks);

        setJMenuBar(menuBar);
    }
}
