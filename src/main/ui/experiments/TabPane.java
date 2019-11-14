package ui.experiments;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

class TabPane extends JFrame implements ListSelectionListener {
    private JFrame frame;
    private JList soilSampleList = new JList();
    private DefaultListModel soilModel;
    private ArrayList samples = new ArrayList();
    private String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
    };

    private String[] columnNames = { "Name", "Roll Number", "Department" };

    JList list;

    DefaultListModel model;

    public static void main(String [] args) {
        TabPane tabbedPane = new TabPane();
    }

    public TabPane() {
        createFrame();



//        DefaultListModel sampleList = new DefaultListModel();
//        sampleList.addElement("Test1");
//        sampleList.addElement("Test2");
//        sampleList.addElement("Test3");
//
//        JList list = new JList(sampleList);

//        frame.add(createSampleList());

//        frame.add(welcomeMsg);
//        frame.add(selectSampleType);
//        frame.add(b1);
//        frame.add(b2);


    }

    private void createFrame() {
        //creates new frame
        frame = new JFrame("Borehole Log App");

        //sets frame properties
        frame.setSize(500, 800);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JLabel welcomeMsg = new JLabel("Welcome to Borehole Logger v.10.0!");
//        welcomeMsg.setBounds(150, 50, 300, 50);

        //sets grid layout for pane
        frame.getContentPane().setLayout(new GridLayout(1, 2));

//        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//
////        creates two tabs
//        tabbedPane.addTab("Soil", makeSoilPanel("Welcome to the soil sample logger!"));
//        tabbedPane.addTab("Water", makeWaterPanel("Add water Functionality"));


        soilModel = new DefaultListModel();
        soilSampleList = new JList(soilModel);
        JScrollPane listScrollPane = new JScrollPane(soilSampleList);
        listScrollPane.setPreferredSize(new Dimension(400, 400));
//        frame.getContentPane().add(tabbedPane);
        frame.getContentPane().add(listScrollPane);

    }

    private JPanel makeSoilPanel(String text) {

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
//        p.setLayout(new GridBagLayout());
//        p.setLayout(null);
        //p.add(new Label(text));
        p.setBackground(new Color(92, 123, 100));
//        p.setLayout(new GridLayout(1, 1));

//        JPanel testPanel = new JPanel();
//        testPanel.setBackground(Color.BLUE);


//
        soilModel = new DefaultListModel();
        soilSampleList = new JList(soilModel);
        JScrollPane listScrollPane = new JScrollPane(soilSampleList);

//        listScrollPane.setViewportView(p);


        JPanel subPanel = new JPanel(new GridLayout(1, 2));
//        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        //p.add(splitPane, BorderLayout.CENTER);


        JButton addButton = new JButton("Add sample");
//        addButton.setBounds(300, 50, 150, 30);
        subPanel.add(addButton);

        JButton removeButton = new JButton("Remove sample");
        removeButton.setBounds(300, 100, 150, 30);
        subPanel.add(removeButton);



//        listScrollPane.0.5);

        //JTextField textField = new JTextField("Test");
        //p.add(textField, BorderLayout.LINE_START);

//        JButton extraButton = new JButton("test");
//        JPanel pp = new JPanel();
//        pp.setBackground(Color.PINK);
//      //extraButton.setBounds(300, 300, 150, 30);

//        soilModel = new DefaultListModel();
//        soilModel.addElement("item 1");
//        soilModel.addElement("item 2");
////
//        soilSampleList = new JList(soilModel);
//        soilSampleList.setSelectionMode(
//                ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        soilSampleList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//        soilSampleList.setSelectedIndex(0);
//        soilSampleList.addListSelectionListener(this);
//
//        JTextField textField = new JTextField("test", 2);



//        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, listScrollPane, testPanel);
//
        //splitPane.setResizeWeight(0.5);

        p.add(listScrollPane, BorderLayout.PAGE_END);
        p.add(subPanel, BorderLayout.PAGE_START);

//        p.add(splitPane, BorderLayout.CENTER);

//create list
        //add to scrollpane
        //add scroll pane to overall

        //do all congation at the end.

//
//        p.add(extraButton);
//        JPanel samplePanel = new JPanel();
//        samplePanel.setBackground(Color.PINK);
//
//        soilModel = new DefaultListModel();
//        soilModel.addElement("item 1");
//        soilModel.addElement("item 2");
////
//        soilSampleList = new JList(soilModel);
//        soilSampleList.setSelectionMode(
//                ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        soilSampleList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//        soilSampleList.setSelectedIndex(0);
//        JScrollPane listScrollPane = new JScrollPane(soilSampleList);
////        listScrollPane.0.5);
//        samplePanel.add(listScrollPane, BorderLayout.CENTER);
//
//
//        p.add(samplePanel, BorderLayout.CENTER);

        return p;
    }

//    private JScrollPane createSoilList() {
////        soilModel = new DefaultListModel();
////        soilModel.addElement("s1");
////        soilModel.addElement("s2");
////        soilModel.addElement("s3");
//        soilSampleList = new JList();
//
//        return new JScrollPane(soilSampleList);
//
//    }


    private JPanel makeWaterPanel(String text) {
        JPanel p = new JPanel();
        p.add(new Label(text));
        p.setBackground(new Color(93, 150, 138));
//        p.setLayout(new GridLayout(1, 1));

        JButton button = new JButton("Add new sample");
        button.setBounds(150, 600, 95, 30);
        p.add(button);

        return p;
    }



    //EFFECTS: create list of samples on side of frame
    private JList createSampleList() {
        DefaultListModel sampleList = new DefaultListModel();
        sampleList.addElement("Test1");
        sampleList.addElement("Test2");
        sampleList.addElement("Test3");

        JList list = new JList(sampleList);
        return list;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("List selection chnaged");
    }
}

