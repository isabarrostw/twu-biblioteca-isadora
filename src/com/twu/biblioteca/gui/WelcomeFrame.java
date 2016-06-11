package com.twu.biblioteca.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {

    private Vector<String> bookTableColumns;
    private Vector<Vector<String>> books;
    private Vector<Vector<String>> checkedOutBooks;
    private JTable bookTable;
    private JScrollPane bookTableScrollPane;
    private JFrame checkoutFrame;
    private JTextField bookTitleTextField;

    public WelcomeFrame() {
        setSize(600,400);
        setLocation(400,200);
        initializeComponents();
        setVisible(true);
    }

    public void initializeBookTable() {
        bookTableColumns = new Vector<String>();
        books = new Vector<Vector<String>>();
        checkedOutBooks = new Vector<Vector<String>>();

        bookTableColumns.addAll(asList("Title", "Author(s)", "Year"));

        String[][] bookList = {
                {"Java Head First", "Bert Bates, Kathy Sierra", "2003"},
                {"Test-Driven Development by Example", "Kent Beck", "2003"},
                {"The Agile Samurai", "Jonathan Rasmusson", "2010"}
        };

        for (int i = 0; i < bookList.length; i++) {
            Vector<String> tmp = new Vector<String>();
            tmp.addAll(asList(bookList[i]));
            books.add(tmp);
        }
    }

    public void initializeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to Bangalore Public Library!", JLabel.CENTER);
        add(welcomeLabel);
        initializeBookTable();
        initializeMenu();
        checkoutFrame = initializeFrame(500, 300, 450, 100);

        JPanel panel = new JPanel();
        JLabel bookTitleLabel = new JLabel("Book title: ");
        bookTitleTextField = new JTextField(30);
        bookTitleTextField.setMinimumSize(new Dimension(100, 40));
        JButton checkoutButton = new JButton("CHECKOUT");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<Vector<String>> iterator = books.iterator();

                boolean elementNotFound = true;
                Vector<String> bookToRemove = new Vector<String>();
                Vector<String> book;
                String title;
                while (iterator.hasNext() && elementNotFound) {
                    book = iterator.next();
                    title = book.get(0);

                    if(title.equals(bookTitleTextField.getText())) {
                        bookToRemove = book;
                        checkedOutBooks.add(bookToRemove);
                        bookTitleTextField.setText("");
                        elementNotFound = false;
                    }
                }
                books.remove(bookToRemove);
            }
        });
        panel.add(bookTitleLabel, 0);
        panel.add(bookTitleTextField, 1);
        panel.add(checkoutButton, 2);
        checkoutFrame.add(panel);
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

    public JFrame initializeFrame(int x, int y, int width, int length) {
        JFrame frame = new JFrame();
        frame.setLocation(x, y);
        frame.setSize(width, length);
        return frame;
    }

    public void initializeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuListBooks = new JMenu("List Books");
        JMenuItem menuAll = new JMenuItem("All");
        JMenuItem menuQuit = new JMenuItem("Quit");
        JMenu menuManageBooks = new JMenu("Manage Books");
        JMenuItem menuCheckout = new JMenuItem("Checkout Book");

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
        menuCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutFrame.setVisible(true);
            }
        });

        menuListBooks.add(menuAll);
        menuListBooks.add(menuQuit);
        menuManageBooks.add(menuCheckout);
        menuBar.add(menuListBooks);
        menuBar.add(menuManageBooks);

        setJMenuBar(menuBar);
    }
}
