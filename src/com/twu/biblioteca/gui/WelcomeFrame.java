package com.twu.biblioteca.gui;

import com.twu.biblioteca.business.Facade;
import com.twu.biblioteca.exceptions.BookNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static java.util.Arrays.asList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {
    private JFrame checkoutFrame;
    private JFrame returnFrame;
    private Facade facade;

    public WelcomeFrame(Facade facade) {
        this.facade = facade;
        setSize(600,400);
        setLocation(400,200);
        initializeComponents();
    }

    public void initializeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to Bangalore Public Library!", JLabel.CENTER);
        add(welcomeLabel);
        initializeMenu();
        checkoutFrame = initializeFrame(500, 300, 450, 120);
        returnFrame = initializeFrame(500, 300, 450, 120);
        checkoutFrame.add(bookManagementPanel("CHECKOUT", "Thank you! Enjoy the book", "That book is not available."));
        returnFrame.add(bookManagementPanel("RETURN", "Thank you for returning the book.",
                "That is not a valid book to return."));
    }

    public void showTableFrame(JTable table) {
        table.setFillsViewportHeight(true);
        JFrame frame = initializeFrame(450, 250, 500, 200);
        JScrollPane tableScrollPane = new JScrollPane(table);
        frame.add(tableScrollPane);
        frame.setVisible(true);
    }

    public JFrame initializeFrame(int x, int y, int width, int length) {
        JFrame frame = new JFrame();
        frame.setLocation(x, y);
        frame.setSize(width, length);
        return frame;
    }

    public JPanel bookManagementPanel(final String action, final String successMessage, final String failureMessage) {
        final JPanel panel = new JPanel();
        JLabel bookTitleLabel = new JLabel("Book title: ");
        final JTextField bookTitleTextField = new JTextField(30);
        bookTitleTextField.setMinimumSize(new Dimension(100, 40));
        JButton checkoutButton = new JButton(action);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(action.equals("CHECKOUT")) {
                        facade.checkoutBook(bookTitleTextField.getText());
                    } else if(action.equals("RETURN")) {
                        facade.returnBook(bookTitleTextField.getText());
                    }
                    showMessageDialog(panel, successMessage);
                    bookTitleTextField.setText("");
                } catch (BookNotFoundException exp) {
                    showMessageDialog(panel, failureMessage);
                }
            }
        });

        panel.add(bookTitleLabel, 0);
        panel.add(bookTitleTextField, 1);
        panel.add(checkoutButton, 2);
        return panel;
    }

    public void initializeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuList = new JMenu("List");
        JMenuItem menuBooks = new JMenuItem("Books");
        JMenuItem menuMovies = new JMenuItem("Movies");
        JMenuItem menuQuit = new JMenuItem("Quit");
        JMenu menuManageBooks = new JMenu("Manage Books");
        JMenuItem menuCheckout = new JMenuItem("Checkout Book");
        JMenuItem menuReturn = new JMenuItem("Return Book");

        menuBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> columns = new Vector<String>();
                columns.addAll(asList("Title", "Author(s)", "Year"));

                JTable booksTable = new JTable(facade.getNotCheckedOutBooksVector(), columns);
                showTableFrame(booksTable);
            }
        });
        menuMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
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
        menuReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnFrame.setVisible(true);
            }
        });

        menuList.add(menuBooks);
        menuList.add(menuMovies);
        menuList.add(menuQuit);
        menuManageBooks.add(menuCheckout);
        menuManageBooks.add(menuReturn);
        menuBar.add(menuList);
        menuBar.add(menuManageBooks);

        setJMenuBar(menuBar);
    }
}
