package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.Box;
import store.Store;
import store.Donut;
import store.Java;
import store.Filling;
import store.Frosting;

public class MainWin extends JFrame {
    private Store store;

    public MainWin(String title) {
        super(title);

        store = new Store("JADE");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        //////////////////////////////////////////////////////////////
        // M E N U

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu create = new JMenu("Create");
        JMenuItem donut = new JMenuItem("Donut");
        JMenuItem java = new JMenuItem("Java");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        donut.addActionListener(event -> onDonutClick());
        java.addActionListener(even -> onJavaClick());
        about.addActionListener(event -> onAboutClick());
        
        file.add(quit);
        create.add(donut);
        create.add(java);
        help.add(about);

        menubar.add(file);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        //////////////////////////////////////////////////////////////
        // T O O L B A R

        JToolBar toolbar = new JToolBar("Tools");

        JButton javaB = new JButton(new ImageIcon("gui/assets/JAVA.png"));
            javaB.setActionCommand("Create a new java");
            javaB.setToolTipText("Create a new java");
            javaB.setBorder(null);
            toolbar.add(javaB);
            javaB.addActionListener(event -> onJavaClick());
    
        JButton donutB = new JButton(new ImageIcon("gui/assets/DONUT.png"));
            donutB.setActionCommand("Create a new donut");
            donutB.setToolTipText("Create a new donut");
            donutB.setBorder(null);
            toolbar.add(donutB);
            donutB.addActionListener(event -> onDonutClick());

        toolbar.add(Box.createHorizontalStrut(25));

        JButton aboutB = new JButton(new ImageIcon("gui/assets/QUESTION.png"));
            aboutB.setActionCommand("About this program");
            aboutB.setToolTipText("About this program");
            aboutB.setBorder(null);
            toolbar.add(aboutB);
            aboutB.addActionListener(event -> onAboutClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
    }

    public static void main(String[] args) {
        MainWin jade = new MainWin("JADE");
        jade.setVisible(true);
    }
    
    // Listeners

    protected void onQuitClick() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    protected void onDonutClick() {
        String name;
        double price;
        double cost;

        try {
            name = JOptionPane.showInputDialog(this, "Donut Name:");
            if (name.equals("")) {
                throw new Exception("Name cannot be left blank");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            price = Double.parseDouble(JOptionPane.showInputDialog(this, "Donut Price:"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            cost = Double.parseDouble(JOptionPane.showInputDialog(this, "Donut Cost:"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Cost!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.store.addProduct(new Donut(name, price, cost, Frosting.unfrosted, false, Filling.unfilled));
        JOptionPane.showMessageDialog(this, this.store.toString());
    }

    protected void onJavaClick() {
        String name;
        double price;
        double cost;

        try {
            name = JOptionPane.showInputDialog(this, "Java Name:");
            if (name.equals("")) {
                throw new Exception("Name cannot be left blank");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Invalid Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            price = Double.parseDouble(JOptionPane.showInputDialog(this, "Donut Price:"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            cost = Double.parseDouble(JOptionPane.showInputDialog(this, "Donut Cost:"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Cost!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.store.addProduct(new Java(name, price, cost, Darkness.Light));
        JOptionPane.showMessageDialog(this, "Java added to menu");
    }

    protected void onAboutClick() {
        //TODO: Display dialog with credits for art used, and copyright information
        JOptionPane.showMessageDialog(this, "All code and art created by Waseem Alkasbutrus");
    }
}