package com.twu.biblioteca.gui;

import com.twu.biblioteca.business.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {
    private JTable bookTable;
    private JScrollPane bookTableScrollPane;
    private JFrame booksFrame;
    private JFrame checkoutFrame;
    private Data data;

    public WelcomeFrame(Data data) {
        this.data = data;
        setSize(600,400);
        setLocation(400,200);
        initializeComponents();
    }

    public void initializeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to Bangalore Public Library!", JLabel.CENTER);
        add(welcomeLabel);
        initializeMenu();
        booksFrame = initializeFrame(450, 250, 500, 200);
        checkoutFrame = initializeFrame(500, 300, 450, 100);
        checkoutFrame.add(checkoutPanel());
    }

    public void showBooksTable() {
        bookTable = new JTable(data.getBooks(), data.getBookTableColumns());
        bookTableScrollPane = new JScrollPane(bookTable);

        bookTable.setFillsViewportHeight(true);
        booksFrame.add(bookTableScrollPane);
        booksFrame.setVisible(true);
    }

    public JFrame initializeFrame(int x, int y, int width, int length) {
        JFrame frame = new JFrame();
        frame.setLocation(x, y);
        frame.setSize(width, length);
        return frame;
    }

    public JPanel checkoutPanel() {
        JPanel panel = new JPanel();
        JLabel bookTitleLabel = new JLabel("Book title: ");
        final JTextField bookTitleTextField = new JTextField(30);
        bookTitleTextField.setMinimumSize(new Dimension(100, 40));
        JButton checkoutButton = new JButton("CHECKOUT");

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.checkoutBook(bookTitleTextField.getText());
                bookTitleTextField.setText("");
            }
        });

        panel.add(bookTitleLabel, 0);
        panel.add(bookTitleTextField, 1);
        panel.add(checkoutButton, 2);
        return panel;
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
