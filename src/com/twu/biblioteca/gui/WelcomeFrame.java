package com.twu.biblioteca.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JMenuItem menuQuit = new JMenuItem("Quit");
        JMenuItem menuAll = new JMenuItem("All");

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
