package com.twu.biblioteca;

import javax.swing.*;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        setSize(600,400);
        setLocation(400,200);
        initializeComponents();
        setVisible(true);
    }

    public void initializeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to Bangalore Public Library!", JLabel.CENTER);
        add(welcomeLabel);
    }
}
