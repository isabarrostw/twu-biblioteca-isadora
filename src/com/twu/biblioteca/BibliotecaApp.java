package com.twu.biblioteca;

import com.twu.biblioteca.business.Data;
import com.twu.biblioteca.gui.WelcomeFrame;

public class BibliotecaApp {
    private WelcomeFrame welcomeFrame;
    private Data data;

    public BibliotecaApp() {
        data = new Data();
        welcomeFrame = new WelcomeFrame(data);
    }

    public void start() {
        welcomeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.start();
    }
}
