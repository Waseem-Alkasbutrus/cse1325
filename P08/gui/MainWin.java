package gui;

import java.util.ArrayList;
import javax.imageio.ImageIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import store.Store;
import store.Donut;
import store.Java;
import store.Filling;
import store.Frosting;
import store.Darkness;
import store.Shot;

public class MainWin extends JFrame {
    private String NAME = "JAVA AND DONUT EXPRESS";
    private String VERSION = "0.2";
    private String FILE_VERSION = "1.0"; 
    private String MAGIC_COOKIE = "WIA®";

    private Store store;
    private File filename;
    private JLabel data;

    private JMenuItem mJava;
    private JButton bJava;
    
    private JMenuItem mDonut;
    private JButton bDonut;

    private JMenuItem mNew;
    private JButton bNew;

    private JMenuItem mOpen;
    private JButton bOpen;

    private JMenuItem mSave;
    private JButton bSave;

    private JMenuItem mSaveAs;
    private JButton bSaveAs;

    public MainWin(String title) {
        super(title);
        store = new Store(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,500);

        this.filename = new File("./saves/default.jade");

        //////////////////////////////////////////////////////////////
        // M E N U

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        mNew    = new JMenuItem("New");
        mOpen   = new JMenuItem("Open...");
        mSave   = new JMenuItem("Save");
        mSaveAs = new JMenuItem("Save As...");
        JMenuItem mQuit = new JMenuItem("Quit");

        JMenu create = new JMenu("Create");
        mDonut = new JMenuItem("Donut");
        mJava = new JMenuItem("Java");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        mNew.addActionListener(even -> onNewClick());
        mOpen.addActionListener(event -> onOpenClick());
        mSave.addActionListener(event -> onSaveClick());
        mSaveAs.addActionListener(event -> onSaveAsClick());
        mQuit.addActionListener(event -> onQuitClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mJava.addActionListener(even -> onCreateJavaClick());
        about.addActionListener(event -> onAboutClick());
        
        file.add(mNew);
        file.addSeparator();
        file.add(mOpen);
        file.addSeparator();
        file.add(mSave);
        file.add(mSaveAs);
        file.addSeparator();
        file.add(mQuit);
        create.add(mDonut);
        create.add(mJava);
        help.add(about);

        menubar.add(file);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        //////////////////////////////////////////////////////////////
        // T O O L B A R

        JToolBar toolbar = new JToolBar("JADE Tools");
        
        bSave = newJButton("gui/assets/SAVE.png", "Save store", "Save store");
            toolbar.add(bSave);
            bSave.addActionListener(event -> onSaveClick());


        bNew = newJButton("gui/assets/NEW.png", "Create a new store", "Create a new store");
            toolbar.add(bNew);
            bNew.addActionListener(event -> onNewClick());

        bOpen = newJButton("gui/assets/OPEN.png", "Open a store from a .jade file", "Open a store from a .jade file");
            toolbar.add(bOpen);
            bOpen.addActionListener(event -> onOpenClick());

        bSaveAs = newJButton("gui/assets/SAVE AS.png", "Save store to a new .jade file", "Save store to a new .jade file");
            toolbar.add(bSaveAs);
            bSaveAs.addActionListener(event -> onSaveAsClick());
        
        toolbar.add(Box.createHorizontalStrut(25));

        bJava = newJButton("gui/assets/JAVA.png", "Create a new java", "Create a new java");
            toolbar.add(bJava);
            bJava.addActionListener(event -> onCreateJavaClick());
    
        bDonut = newJButton("gui/assets/DONUT.png", "Create a new donut", "Create a new donut");
            toolbar.add(bDonut);
            bDonut.addActionListener(event -> onCreateDonutClick());

        toolbar.add(Box.createHorizontalStrut(25));

        JButton bAbout = newJButton("gui/assets/ABOUT.png", "About this program", "About this program");
            toolbar.add(bAbout);
            bAbout.addActionListener(event -> onAboutClick());

        //////////////////////////////////////////////////////////////
        // S T O R E  M E N U

        data = new JLabel(toHtml(this.store.toString()), JLabel.LEFT);
        data.setVerticalAlignment(JLabel.TOP);

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        getContentPane().add(data, BorderLayout.CENTER);
    }

    //CancelDialogException originally written by professor George F. Rice, reused by Waseem Alkasbutrus
    protected class CancelDialogException extends Exception {
        public CancelDialogException() {
            super("Dialog canceled");
        }
    }

    public static void main(String[] args) {
        MainWin jade = new MainWin("JADE");
        jade.setVisible(true);
    }
    
    //////////////////////////////////////////////////////////////
    // B U T T O N   A C T I O N S
    protected void onNewClick() {
        try {
            Store newStore = new Store(getString("Store name", "New Store", JOptionPane.QUESTION_MESSAGE));
            this.store = newStore;
            this.data.setText(toHtml(this.store.toString()));
            return;
        } catch (CancelDialogException e) {
            return;
        }
    }

    protected void onOpenClick() {
        final JFileChooser fileChooser = new JFileChooser(this.filename);
        FileNameExtensionFilter jadeFileFilter = new FileNameExtensionFilter("jade files (.jade)", "jade");
        fileChooser.addChoosableFileFilter(jadeFileFilter);
        fileChooser.setFileFilter(jadeFileFilter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        } else if (result == JFileChooser.APPROVE_OPTION) {
            this.filename = fileChooser.getSelectedFile();
        }

        if (!this.filename.getAbsolutePath().endsWith(".jade")) {
            this.filename = new File(this.filename.getAbsolutePath() + ".jade");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filename))) {
            String magicCookie = bufferedReader.readLine();
            if (!magicCookie.equals(MAGIC_COOKIE)) {
                throw new Exception("Not a jade file");
            }

            String fileVersion = bufferedReader.readLine();
            if (!fileVersion.equals(FILE_VERSION)) {
                throw new Exception("Incompatible jade file format");
            }

            this.store = new Store(bufferedReader);

            this.data.setText(toHtml(this.store.toString()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open file || " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.filename))) {
            bufferedWriter.write(MAGIC_COOKIE + '\n');
            bufferedWriter.write(FILE_VERSION + '\n');
            
            this.store.save(bufferedWriter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onSaveAsClick() {
        final JFileChooser fileChooser = new JFileChooser(this.filename);
        FileNameExtensionFilter jadeFileFilter = new FileNameExtensionFilter("jade files (.jade)", "jade");
        fileChooser.addChoosableFileFilter(jadeFileFilter);
        fileChooser.setFileFilter(jadeFileFilter);

        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        } else if (result == JFileChooser.APPROVE_OPTION) {
            this.filename = fileChooser.getSelectedFile();
        }

        if (!this.filename.getAbsolutePath().endsWith(".jade")) {
            this.filename = new File(this.filename.getAbsolutePath() + ".jade");
        }

        onSaveClick();
    }

    protected void onQuitClick() {
        int choice = JOptionPane.showConfirmDialog(this, "Save before exiting?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.CANCEL_OPTION) {
            return;
        } else if (choice == JOptionPane.YES_OPTION) {
            onSaveClick();
        }

        System.exit(0);
    }

    protected void onCreateDonutClick() {
        String name;
        double price;
        double cost;

        try {
            name = getString("Donut Name", "Donut Name", JOptionPane.QUESTION_MESSAGE);
        } catch (CancelDialogException e) {
            return;
        }

        try {
            price = getDouble("Donut Price", "Donut Price", JOptionPane.QUESTION_MESSAGE);
        } catch (Exception e) {
            return;
        }

        try {
            cost = getDouble("Donut Cost", "Donut Cost", JOptionPane.QUESTION_MESSAGE);
        } catch (Exception e) {
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
        Darkness darkness;
        ArrayList<Shot> shots = new ArrayList<>();

        try {
            name = getString("Java Name", "Java Name", JOptionPane.QUESTION_MESSAGE);
        } catch (CancelDialogException e) {
            return;
        }

        try {
            price = getDouble("Java Price", "Java Price", JOptionPane.QUESTION_MESSAGE);
        } catch (CancelDialogException e) {
            return;
        }

        try {
            cost = getDouble("Java Cost", "Java Cost", JOptionPane.QUESTION_MESSAGE);
        } catch (CancelDialogException e) {
            return;
        }

        darkness = (Darkness) JOptionPane.showInputDialog(this, "Java Darkness", "Java Darkness", JOptionPane.QUESTION_MESSAGE, null, Darkness.values(), Darkness.blond);
        if (darkness == null) {
            return;
        }

        while (true) {
            Shot s = (Shot) JOptionPane.showInputDialog(this, "Java Shots", "Java Shots", JOptionPane.QUESTION_MESSAGE, null, Shot.values(), Shot.none);
            if (s == Shot.none) {
                shots.add(s);
                break;
                
            } else if (s == null) {
                return;
            } else {
                shots.add(s);
            }
        }

        Java java = new Java(name, price, cost, darkness);
        
        for (Shot s : shots) {
            java.addShot(s);
        }

        this.store.addProduct(java);
        
        this.data.setText(toHtml(this.store.toString()));
        JOptionPane.showMessageDialog(this, "Java was added to store menu");
    }

    protected void onAboutClick() {
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
                                + "<p><font size =+4>" + this.NAME + "</font></p>"
                                + "</html>");
        
        JLabel body = new JLabel("<html>"
                                + "<p>Version "+ this.VERSION + "</p>"
                                + "<p>Copyright 2021 by Waseem Alkasbutrus</p>"
                                + "<p>Licensed under Gnu GPL 3.0</p>"
                                + "<p></p>"
                                + "<p>-Logo and all toolbar button icons created by Waseem Alkasbutrus</p>"
                                + "<p>-CancelDialogException by George F. Rice, licensed under Gnu GPL 3.0</p>"
                                + "<p>-getDouble, and getString methods by George F. Rice, licensed under Gnu GPL 3.0</p>"
                                + "</html>");
        about.add(title);
        about.add(body);

        JOptionPane.showMessageDialog(this, about, "JADE", JOptionPane.PLAIN_MESSAGE, null);
    }

    //////////////////////////////////////////////////////////////
    //U T I L S

    //Implmentation for getDouble followed professor rice's implimentation closely
    protected Double getDouble(String message, String title, int messageType) throws CancelDialogException {
        while (true) {
            try {
                String stringInput = JOptionPane.showInputDialog(this, message, title, messageType);
                if (stringInput == null) {
                    throw new CancelDialogException();
                } else {
                    double parsedDouble = Double.parseDouble(stringInput);
                    return parsedDouble;
                }
            } catch (CancelDialogException e) {
                throw e;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //Implmentation for getString followed professor rice's implimentation closely
    protected String getString(String message, String title, int messageType) throws CancelDialogException {
        while (true) {
            try {
                String inputString = JOptionPane.showInputDialog(this, message, title, messageType);
                if (inputString == null) {
                    throw new CancelDialogException();
                } else if (inputString.equals("")) {
                    JOptionPane.showMessageDialog(this, "Invalid Input!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    return inputString;
                }
            } catch (CancelDialogException e) {
                throw e;
            }
        }
    }

    protected String toHtml(String plainText) {
        return "<html>" + plainText.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>");
    }

    protected JButton newJButton(String iconPath, String actionCommand, String toolTip) {
        JButton bNewButton = new JButton(new ImageIcon(iconPath));
        bNewButton.setActionCommand(actionCommand);
        bNewButton.setToolTipText(toolTip);
        bNewButton.setBorder(null);

        return bNewButton;
    }
}