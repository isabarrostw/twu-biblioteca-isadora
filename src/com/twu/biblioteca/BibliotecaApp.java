package com.twu.biblioteca;

import com.twu.biblioteca.business.Data;
import com.twu.biblioteca.business.Facade;
import com.twu.biblioteca.gui.WelcomeFrame;

public class BibliotecaApp {
    private WelcomeFrame welcomeFrame;
    private Data data;
    private Facade facade;

    public BibliotecaApp() {
        data = new Data();
        facade = new Facade(data);
        welcomeFrame = new WelcomeFrame(facade);
    }

    public void start() {
        welcomeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.start();
    }
}
