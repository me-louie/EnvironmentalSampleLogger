package ui.gui;


import model.BoreholeLog;
import model.Sample;
import model.SoilSample;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;

class TabPane extends JFrame {
    private JFrame frame;
    private JList soilSampleList = new JList();
    private DefaultListModel soilModel;
    private ArrayList samples = new ArrayList();
    private String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
    };

    private String[] columnNames = { "Name", "Roll Number", "Department" };

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
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JLabel welcomeMsg = new JLabel("Welcome to Borehole Logger v.10.0!");
//        welcomeMsg.setBounds(150, 50, 300, 50);

        //sets grid layout for pane
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        //creates two tabs
        tabbedPane.addTab("Soil", makeSoilPanel("Welcome to the soil sample logger!"));
        tabbedPane.addTab("Water", makeWaterPanel("Add water Functionality"));

        frame.getContentPane().add(tabbedPane);

    }

    private JPanel makeSoilPanel(String text) {
        JPanel p = new JPanel();
        p.add(new Label(text));
        p.setBackground(new Color(92, 123, 100));
//        p.setLayout(new GridLayout(1, 1));



        JButton addButton = new JButton("Add sample");
        addButton.setBounds(150, 50, 95, 30);
        p.add(addButton);

        JButton removeButton = new JButton("Remove sample");
        removeButton.setBounds(150, 600, 95, 30);
        p.add(removeButton);

//        JTable table = new JTable(data, columnNames);
//        table.setBounds(40, 40, 40, 40);
//        p.add(table);
//        p.setVisible(true);
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
}

