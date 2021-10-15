public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        //////////////////////////////////////////////////////////////
        // M E N U

        JMenuBar menubar = new MenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu create = new JMenu("Create");
        JMenuItem donut = new JMenuItem("Donut");
        JmenuItem java = new JMenuItem("Java");

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

        // Listeners

        protected void onQuitClick() {
            //TODO: Exit program
        }

        protected void onDonutClick() {
            //TODO: Create a series of dialogs to collect info needed to create a new donut object and add it to store
        }

        protected void onJavaClick() {
            //TODO: Create a series of dialogs to collect info needed to create a new java object and add it to store
        }

        protected void onAboutClick() {
            //TODO: Display dialog with credits for art used, and copyright information
        }
    }
}