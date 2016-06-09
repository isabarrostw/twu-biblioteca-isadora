package com.twu.biblioteca.gui;

import javax.swing.*;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        setSize(600,400);
        setLocation(400,200);
        initializeComponents();
        initializeMenu();
        setVisible(true);
    }

    public void initializeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to Bangalore Public Library!", JLabel.CENTER);
        add(welcomeLabel);
    }

    public void initializeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuListBooks = new JMenu("List Books");
        JMenuItem menuAll = new JMenu("All");

        menuListBooks.add(menuAll);
        menuBar.add(menuListBooks);

        setJMenuBar(menuBar);
    }
}
