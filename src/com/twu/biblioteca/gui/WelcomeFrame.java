package com.twu.biblioteca.gui;

import com.twu.biblioteca.business.Book;
import com.twu.biblioteca.business.Facade;
import com.twu.biblioteca.business.Movie;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by ibarros on 6/9/16.
 */
public class WelcomeFrame extends JFrame {
    private JFrame checkoutFrame;
    private JFrame returnFrame;
    private JFrame checkoutMovieFrame;
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
        checkoutMovieFrame = initializeFrame(500, 300, 450, 120);
        checkoutFrame.add(resourceManagementPanel("Book", "CHECKOUT", "Thank you! Enjoy the book", "That book is not available."));
        returnFrame.add(resourceManagementPanel("Book", "RETURN", "Thank you for returning the book.",
                "That is not a valid book to return."));
        checkoutMovieFrame.add(resourceManagementPanel("Movie", "CHECKOUT", "Thank you! Enjoy the movie", "That movie is not available."));
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

    public JPanel resourceManagementPanel(final String resourceName, final String action, final String successMessage,
                                          final String failureMessage) {
        final JPanel panel = new JPanel();
        JLabel bookTitleLabel = new JLabel(resourceName + " title: ");
        final JTextField bookTitleTextField = new JTextField(30);
        bookTitleTextField.setMinimumSize(new Dimension(100, 40));
        JButton checkoutButton = new JButton(action);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(action.equals("CHECKOUT")) {
                        if (resourceName.equals("Book"))
                            facade.checkoutBook(bookTitleTextField.getText());
                        else if(resourceName.equals("Movie"))
                            facade.checkoutMovie(bookTitleTextField.getText());
                    } else if(action.equals("RETURN")) {
                        facade.returnBook(bookTitleTextField.getText());
                    }
                    showMessageDialog(panel, successMessage);
                    bookTitleTextField.setText("");
                } catch (BookNotFoundException exp) {
                    showMessageDialog(panel, failureMessage);
                } catch (MovieNotFoundException exp) {
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
        JMenu menuManageMovies = new JMenu("Manage Movies");
        JMenuItem menuCheckoutMovie = new JMenuItem("Checkout Movie");

        menuBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Title", "Author(s)", "Year"};
                JTable booksTable = new JTable(availableBooks(facade.findAvailableBooks()), columns);
                showTableFrame(booksTable);
            }
        });
        menuMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Name", "Director(s)", "Year", "Rating"};
                JTable moviesTable = new JTable(availableMovies(facade.findAvailableMovies()), columns);
                showTableFrame(moviesTable);
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
        menuCheckoutMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutMovieFrame.setVisible(true);
            }
        });

        menuList.add(menuBooks);
        menuList.add(menuMovies);
        menuList.add(menuQuit);
        menuManageBooks.add(menuCheckout);
        menuManageBooks.add(menuReturn);
        menuManageMovies.add(menuCheckoutMovie);
        menuBar.add(menuList);
        menuBar.add(menuManageBooks);
        menuBar.add(menuManageMovies);

        setJMenuBar(menuBar);
    }

    private String[][] availableBooks(List<Book> books) {
        String[][] bidimensionalArray = new String[books.size()][3];

        for (int i = 0; i < books.size(); i++) {
            bidimensionalArray[i] = toArray(books.get(i));
        }

        return bidimensionalArray;
    }

    public String[] toArray(Book book) {
        String[] array = { book.getTitle(), book.getAuthor(), book.getYear() };
        return array;
    }

    private String[][] availableMovies(List<Movie> movies) {
        String[][] bidimensionalArray = new String[movies.size()][4];

        for (int i = 0; i < movies.size(); i++) {
            bidimensionalArray[i] = toArray(movies.get(i));
        }

        return bidimensionalArray;
    }

    public String[] toArray(Movie movie) {
        String[] array = { movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating() + "" };
        return array;
    }
}
