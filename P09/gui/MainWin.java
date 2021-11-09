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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import store.Store;
import store.Donut;
import store.Java;
import store.Filling;
import store.Frosting;
import store.Darkness;
import store.Shot;
import store.Customer;

enum ViewMode {Product, People};

public class MainWin extends JFrame {
    private String NAME = "JAVA AND DONUT EXPRESS";
    private String VERSION = "0.3";
    private String FILE_VERSION = "1.1"; 
    private String MAGIC_COOKIE = "WIA®";

    private boolean unsavedChanges;
    private ViewMode viewMode;

    private Store store;
    private File filename;
    private JLabel data;
    private JToolBar toolbar;

    private JMenuItem mJava;
    private JButton bJava;
    
    private JMenuItem mDonut;
    private JButton bDonut;

    private JMenuItem mCustomer;
    private JButton bCustomer;

    private JMenuItem mNew;
    private JButton bNew;

    private JMenuItem mOpen;
    private JButton bOpen;

    private JMenuItem mSave;
    private JButton bSave;

    private JMenuItem mSaveAs;
    private JButton bSaveAs;

    private JMenuItem mPeople;
    private JButton bPeople;

    private JMenuItem mProducts;
    private JButton bProducts;

    public MainWin(String title) {
        super(title);
        this.filename = new File("./saves/default.jade");
        this.viewMode = ViewMode.Product;
                
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(750,500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onQuitClick(); // Call this when 'x' is clicked
            }
        });

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
        mCustomer = new JMenuItem("Customer");


        JMenu view = new JMenu("View");
        mPeople = new JMenuItem("Customers");
        mProducts = new JMenuItem("Products");

        JMenu help = new JMenu("Help");
        JMenuItem mAbout = new JMenuItem("About");

        mNew.addActionListener(even -> onNewClick());
        mOpen.addActionListener(event -> onOpenClick());
        mSave.addActionListener(event -> onSaveClick());
        mSaveAs.addActionListener(event -> onSaveAsClick());
        mQuit.addActionListener(event -> onQuitClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mJava.addActionListener(event -> onCreateJavaClick());
        mCustomer.addActionListener(event -> onCreateCustomerClick());
        mPeople.addActionListener(event -> onPeopleClick());
        mProducts.addActionListener(event -> onProductsClick());
        mAbout.addActionListener(event -> onAboutClick());
        
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
        create.addSeparator();
        create.add(mCustomer);
        view.add(mPeople);
        view.add(mProducts);
        help.add(mAbout);

        menubar.add(file);
        menubar.add(create);
        menubar.add(view);
        menubar.add(help);

        setJMenuBar(menubar);

        //////////////////////////////////////////////////////////////
        // T O O L B A R

        this.toolbar = new JToolBar("JADE Tools");
        
        bNew = newJButton("gui/assets/NEW.png", "Create a new store", "Create a new store");
        bNew.addActionListener(event -> onNewClick());
        
        bOpen = newJButton("gui/assets/OPEN.png", "Open a store from a .jade file", "Open a store from a .jade file");
        bOpen.addActionListener(event -> onOpenClick());
        
        bSave = newJButton("gui/assets/SAVE.png", "Save store", "Save store");
        bSave.addActionListener(event -> onSaveClick());
        
        bSaveAs = newJButton("gui/assets/SAVE AS.png", "Save store to a new .jade file", "Save store to a new .jade file");
        bSaveAs.addActionListener(event -> onSaveAsClick());
        
        toolbar.add(Box.createHorizontalStrut(25));

        bJava = newJButton("gui/assets/JAVA.png", "Create a new java", "Create a new java");
        bJava.addActionListener(event -> onCreateJavaClick());
    
        bDonut = newJButton("gui/assets/DONUT.png", "Create a new donut", "Create a new donut");
        bDonut.addActionListener(event -> onCreateDonutClick());

        bCustomer = newJButton("gui/assets/CUSTOMER.png", "Create a new customer", "Create a new customer");
        bCustomer.addActionListener(event -> onCreateCustomerClick());

        toolbar.add(Box.createHorizontalStrut(25));

        bPeople = newJButton("gui/assets/VIEW PEOPLE.png", "View customers", "View customers");
        bPeople.addActionListener(event -> onPeopleClick());

        bProducts = newJButton("gui/assets/VIEW PRODUCTS.png", "View products", "View products");
        bProducts.addActionListener(event -> onProductsClick());

        toolbar.add(Box.createHorizontalStrut(25));

        JButton bAbout = newJButton("gui/assets/ABOUT.png", "About this program", "About this program");
        bAbout.addActionListener(event -> onAboutClick());
            
        //////////////////////////////////////////////////////////////
        // S T O R E  D A T A

        this.store = new Store(title);

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
    
    //////////////////////////////////////////////////////////////
    // B U T T O N   A C T I O N S
    protected void onNewClick() {
        try {
            Store newStore = new Store(getString("Store name", "New Store", JOptionPane.QUESTION_MESSAGE));

            if (unsavedChanges) {
                try {
                    unsavedChangesDialog();
                } catch (CancelDialogException e) {
                    return;
                }
            }

            this.store = newStore;
            this.data.setText(toHtml(this.store.toString()));
            this.unsavedChanges = true;
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

            if (unsavedChanges) {
                try {
                    unsavedChangesDialog();
                } catch (CancelDialogException e) {
                    return;
                }
            }

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
                throw new Exception("Incompatible file version");
            }

            this.store = new Store(bufferedReader);
            this.data.setText(toHtml(this.store.toString()));
            this.unsavedChanges = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open file: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    protected void onSaveClick() {
        if (this.filename == null) {onSaveAsClick();}
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.filename))) {
            bufferedWriter.write(MAGIC_COOKIE + '\n');
            bufferedWriter.write(FILE_VERSION + '\n');
            
            this.store.save(bufferedWriter);
            this.unsavedChanges = false;
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
        if (unsavedChanges) {
            try {
                unsavedChangesDialog();
            } catch (CancelDialogException e) {
                return;
            }
        }

        System.exit(0);
    }

    protected void onCreateDonutClick() {
        //Donut Fields
        String name;
        double price;
        double cost;
        Frosting frosting;
        boolean sprinkles;
        Filling filling;
      
        //Dialog Components
        JLabel lName = new JLabel("Name:");
        JTextField tName = new JTextField(20);

        SpinnerModel sPriceModel = new SpinnerNumberModel(0.01, 0.01, 1000.0, 0.01);
        JLabel lPrice = new JLabel("Price:");
        JSpinner sPrice = new JSpinner(sPriceModel);
        
        SpinnerModel sCostModel = new SpinnerNumberModel(0.01, 0.01, 1000.0, 0.01);
        JLabel lCost = new JLabel("Cost:");
        JSpinner sCost = new JSpinner(sCostModel);

        JLabel lFrosting = new JLabel("Frosting:");
        JComboBox<Frosting> cFrosting = new JComboBox<>(Frosting.values());

        JLabel lSprinkles = new JLabel("Sprinkles:");
        String yesNoOpts[] = {"Yes", "No"};
        JComboBox<String> cSprinkles = new JComboBox<>(yesNoOpts);

        JLabel lFilling = new JLabel("Filling:");
        JComboBox<Filling> cFilling = new JComboBox<>(Filling.values());
        
        Object newDonutComponents[] = {
            lName, tName,
            lPrice, sPrice,
            lCost, sCost,
            lFrosting, cFrosting,
            lSprinkles, cSprinkles,
            lFilling, cFilling
        };

        while (true) {
            int choice = JOptionPane.showConfirmDialog(this, newDonutComponents, "New Donut", JOptionPane.OK_CANCEL_OPTION);

            if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            } else {
                name = tName.getText();
                if (name.equals("") || name == null) {
                    JOptionPane.showMessageDialog(this, "Name Cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
    
                price = (double) sPriceModel.getValue();
                cost = (double) sCostModel.getValue();
    
                frosting = (Frosting) cFrosting.getSelectedItem();
    
                sprinkles = (cSprinkles.getSelectedItem().equals("Yes")) ? true : false;
                if (frosting == Frosting.unfrosted && sprinkles) {
                    JOptionPane.showMessageDialog(this, "Sprinkles require frosting on the donut", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
    
                filling = (Filling) cFilling.getSelectedItem();
    
                break;
            }
        }

        //Adding donut to store
        this.store.addProduct(new Donut(name, price, cost, frosting, sprinkles, filling));
        updateData();
        JOptionPane.showMessageDialog(this, "Donut was added to store menu");
        
        this.unsavedChanges = true;
    }

    protected void onCreateJavaClick() {
        String name;
        double price;
        double cost;
        Darkness darkness;
        ArrayList<Shot> shots = new ArrayList<>();

        JLabel lName = new JLabel("Name:");
        JTextField tName = new JTextField(20);

        SpinnerModel sPriceModel = new SpinnerNumberModel(0.01, 0.01, 1000.0, 0.01);
        JLabel lPrice = new JLabel("Price:");
        JSpinner sPrice = new JSpinner(sPriceModel);

        SpinnerModel sCostModel = new SpinnerNumberModel(0.01, 0.01, 1000.0, 0.01);
        JLabel lCost = new JLabel("Cost:");
        JSpinner sCost = new JSpinner(sCostModel);

        JLabel lDarkness = new JLabel("Darkness:");
        JComboBox<Darkness> cDakness = new JComboBox<>(Darkness.values());

        Object newJavaComponents[] = {
            lName, tName,
            lPrice, sPrice,
            lCost, sCost,
            lDarkness, cDakness
        };

        while (true) {
            int choice = JOptionPane.showConfirmDialog(this, newJavaComponents, "New Java", JOptionPane.OK_CANCEL_OPTION);

            if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            } else {
                name = tName.getText();
                if (name.equals("") || name == null) {
                    JOptionPane.showMessageDialog(this, "Name Cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
    
                price = (double) sPriceModel.getValue();
                cost = (double) sCostModel.getValue();
    
                darkness = (Darkness) cDakness.getSelectedItem();

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
    
                break;
            }
        }

        Java java = new Java(name, price, cost, darkness);
        
        for (Shot s : shots) {
            java.addShot(s);
        }

        this.store.addProduct(java);
        updateData();
        JOptionPane.showMessageDialog(this, "Java was added to store menu");

        this.unsavedChanges = true;
    }

    protected void onCreateCustomerClick() {
        JLabel lName = new JLabel("Customer Name:");
        JTextField tName = new JTextField(20);
        JLabel lPhone = new JLabel("Phone Number:");
        JTextField tPhone = new JTextField(20);

        Object objects[] = {
            lName, tName,
            lPhone, tPhone
        };
        
        while (true) {
            int choice = JOptionPane.showConfirmDialog(this, objects, "New Customer", JOptionPane.OK_CANCEL_OPTION);
    
            if (choice == JOptionPane.CANCEL_OPTION) {
                break;
            } else if (!(tName.getText() == null || tPhone.getText().equals("")) && !(tPhone.getText() == null || tPhone.getText().equals(""))) {
                this.store.addPerson(new Customer(tName.getText(), tPhone.getText()));
                updateData();
                JOptionPane.showMessageDialog(this, "Customer was added to the store");
                
                this.unsavedChanges = true;
                break;
            } else {
                JOptionPane.showMessageDialog(this, "All fields must be filled", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void updateData() {
        if (this.viewMode == ViewMode.Product) {onProductsClick();}
        else if (this.viewMode == ViewMode.People) {onPeopleClick();}
    }

    protected void onPeopleClick() {
        this.viewMode = ViewMode.People;
        this.data.setText(toHtml(this.store.peopleToString()));
    }

    protected void onProductsClick() {
        this.viewMode = ViewMode.Product;
        this.data.setText(toHtml(this.store.toString()));
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
    // U T I L S

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

    protected void unsavedChangesDialog() throws CancelDialogException {
        String buttonOptions[] = {"Save", "Discard", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this, "Save changes to " + this.filename.getName() + "?", "Save Changes?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, buttonOptions, buttonOptions[0]);
    
        if (choice == 0) {
            onSaveClick();
        } else if (choice == 2) {
            throw new CancelDialogException();
        }
    }

    protected JButton newJButton(String iconPath, String actionCommand, String toolTip) {
        JButton bNewButton = new JButton(new ImageIcon(iconPath));
        bNewButton.setActionCommand(actionCommand);
        bNewButton.setToolTipText(toolTip);
        bNewButton.setBorder(null);
        this.toolbar.add(bNewButton);
        return bNewButton;
    }

    //////////////////////////////////////////////////////////////
    // M A I N
    public static void main(String[] args) {
        MainWin jade = new MainWin("JADE");
        jade.setVisible(true);
    }
}