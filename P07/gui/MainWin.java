package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.Box;
import javax.imageio.ImageIO;
import java.io.File;
import store.Store;
import store.Donut;
import store.Java;
import store.Filling;
import store.Frosting;
import store.Darkness;
import store.Shot;

public class MainWin extends JFrame {
    private Store store;
    private JLabel data;
    private JMenuItem mJava;
    private JButton bJava;
    private JMenuItem mDonut;
    private JButton bDonut;

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
        mDonut = new JMenuItem("Donut");
        mJava = new JMenuItem("Java");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mJava.addActionListener(even -> onCreateJavaClick());
        about.addActionListener(event -> onAboutClick());
        
        file.add(quit);
        create.add(mDonut);
        create.add(mJava);
        help.add(about);

        menubar.add(file);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        //////////////////////////////////////////////////////////////
        // T O O L B A R

        JToolBar toolbar = new JToolBar("Tools");

        bJava = new JButton(new ImageIcon("gui/assets/JAVA.png"));
            bJava.setActionCommand("Create a new java");
            bJava.setToolTipText("Create a new java");
            bJava.setBorder(null);
            toolbar.add(bJava);
            bJava.addActionListener(event -> onCreateJavaClick());
    
        bDonut = new JButton(new ImageIcon("gui/assets/DONUT.png"));
            bDonut.setActionCommand("Create a new donut");
            bDonut.setToolTipText("Create a new donut");
            bDonut.setBorder(null);
            toolbar.add(bDonut);
            bDonut.addActionListener(event -> onCreateDonutClick());

        toolbar.add(Box.createHorizontalStrut(25));

        JButton bAbout = new JButton(new ImageIcon("gui/assets/QUESTION.png"));
            bAbout.setActionCommand("About this program");
            bAbout.setToolTipText("About this program");
            bAbout.setBorder(null);
            toolbar.add(bAbout);
            bAbout.addActionListener(event -> onAboutClick());

        //////////////////////////////////////////
        // S T O R E  M E N U

        data = new JLabel(toHtml(this.store.toString()), JLabel.LEFT);
        data.setVerticalAlignment(JLabel.TOP);

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        getContentPane().add(data, BorderLayout.CENTER);
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

    protected void onCreateDonutClick() {
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

        Frosting frosting = (Frosting) JOptionPane.showInputDialog(this, "Donut Frosting", "Donut Frosting", JOptionPane.QUESTION_MESSAGE, null, Frosting.values(), Frosting.unfrosted);
        if (frosting == null) {
            return;
        }

        boolean sprinkles = false;
        if (frosting != Frosting.unfrosted) {
            int n = JOptionPane.showConfirmDialog(this, "Add Sprinkles to Donut?", "Donut Sprinkles", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if (n == JOptionPane.YES_OPTION) {sprinkles = true;}
            else if (n == JOptionPane.CANCEL_OPTION) {return;}
        }

        Filling filling = (Filling) JOptionPane.showInputDialog(this, "Donut Filling", "Donut Filling", JOptionPane.QUESTION_MESSAGE, null, Filling.values(), Filling.unfilled);
        if (filling == null) {
            return;
        }

        this.store.addProduct(new Donut(name, price, cost, frosting, sprinkles, filling));

        this.data.setText(toHtml(this.store.toString()));

        JOptionPane.showMessageDialog(this, "Donut was added to store menu");
    }

    protected void onCreateJavaClick() {
        String name;
        double price;
        double cost;

        try {
            name = JOptionPane.showInputDialog(this, "Java Name:", "Java Name", JOptionPane.QUESTION_MESSAGE);
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
            price = Double.parseDouble(JOptionPane.showInputDialog(this, "Java Price:", "Java Price", JOptionPane.QUESTION_MESSAGE));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            cost = Double.parseDouble(JOptionPane.showInputDialog(this, "Java Cost:", "Java Cost", JOptionPane.QUESTION_MESSAGE));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Cost!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Darkness darkness = (Darkness) JOptionPane.showInputDialog(this, "Java Darkness", "Java Darkness", JOptionPane.QUESTION_MESSAGE, null, Darkness.values(), Darkness.blond);
        if (darkness == null) {
            return;
        }

        Shot shot = (Shot) JOptionPane.showInputDialog(this, "Java Shots", "Java Shots", JOptionPane.QUESTION_MESSAGE, null, Shot.values(), Shot.none);
        if (shot == null) {
            return;
        }

        Java java = new Java(name, price, cost, darkness);
        java.addShot(shot);
        this.store.addProduct(java);
        
        this.data.setText(toHtml(this.store.toString()));
        JOptionPane.showMessageDialog(this, "Java was added to store menu");
    }

    protected void onAboutClick() {
        //TODO: Display dialog with credits for art used, and copyright information
        JPanel about = new JPanel();
        about.setLayout(new BoxLayout(about, BoxLayout.PAGE_AXIS));

        try {
            BufferedImage jadeBufferedLogo = ImageIO.read(new File("gui/assets/JD.png"));
            JLabel jadeLogo = new JLabel(new ImageIcon(jadeBufferedLogo));
            jadeLogo.setHorizontalAlignment(JLabel.CENTER);
            about.add(jadeLogo);
        } catch (Exception e) {
            //ignore the image if the file was not found
        }

        JLabel title = new JLabel("<html>"
                                + "<p><font size =+4>Java and Donut Express</font></p>"
                                + "</html>");
        
        JLabel body = new JLabel("<html>"
                                + "<p>Version 0.1</p>"
                                + "<p>Copyright 2021 by Waseem Alkasbutrus</p>"
                                + "<p>Licensed under Gnu GPL 3.0"
                                + "<p></p>"
                                + "<p>Logo and icon buttons created by Waseem Alkasbutrus"
                                + "</html>");
        about.add(title);
        about.add(body);

        JOptionPane.showMessageDialog(this, about, "JADE", JOptionPane.PLAIN_MESSAGE, null);
    }

    protected String toHtml(String plainText) {
        return "<html>" + plainText.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>");
    }
}