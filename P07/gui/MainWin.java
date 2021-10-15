import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainWin extends JFrame {
    //private Store store;

    public MainWin(String title) {
        super(title);
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
        //TODO: Create a series of dialogs to collect info needed to create a new donut object and add it to store

        String name = JOptionPane.showInputDialog(this, "Donut Name:");
    }

    protected void onJavaClick() {
        //TODO: Create a series of dialogs to collect info needed to create a new java object and add it to store
        
        String name = JOptionPane.showInputDialog(this, "Java Name:");
    }

    protected void onAboutClick() {
        //TODO: Display dialog with credits for art used, and copyright information
        JOptionPane.showMessageDialog(this, "All code and art created by Waseem Alkasbutrus");
    }
}