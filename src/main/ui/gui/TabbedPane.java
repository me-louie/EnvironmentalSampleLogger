package ui.gui;

import javax.swing.*;
import java.awt.*;

class TabbedPane {
    public static void main(String args[]) {
        TabbedPane tabbedPane = new TabbedPane();
    }

    public TabbedPane() {

        //creates new frame
        JFrame frame = new JFrame("Borehole Log App");

        //sets frame properties
        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeMsg = new JLabel("Welcome to Borehole Logger v.10.0!");
        welcomeMsg.setBounds(150, 50, 300, 50);

        //sets grid layout for pane
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        tabbedPane.addTab("Soil", makePanel("Add soil Functionality"));
        tabbedPane.addTab("Water", makePanel("Add water Functionality"));

        frame.getContentPane().add(tabbedPane);

//        DefaultListModel sampleList = new DefaultListModel();
//        sampleList.addElement("Test1");
//        sampleList.addElement("Test2");
//        sampleList.addElement("Test3");
//
//        JList list = new JList(sampleList);

        frame.add(createSampleList());

//        frame.add(welcomeMsg);
//        frame.add(selectSampleType);
//        frame.add(b1);
//        frame.add(b2);


    }

    private JPanel makePanel(String text) {
        JPanel p = new JPanel();
        p.add(new Label(text));
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


//    final JTextField tf = new JTextField();
//        tf.setBounds(150, 200, 300, 50);
//                JButton b1 = new JButton("Enter");
//                b1.setBounds(150, 600, 95, 30);
//                b1.addActionListener(new ActionListener() {
//public void actionPerformed(ActionEvent e) {
//        tf.setText("Welcome to Javatpoint.");
//        }
//        });

//        JLabel selectSampleType = new JLabel("What type of sample would you like to access?");
//        selectSampleType.setBounds(150, 100, 300, 50);
//
//        JButton b1 = new JButton("Soil");
//        b1.setBounds(200, 300, 95, 30);
//
//        JButton b2 = new JButton("Water");
//        b2.setBounds(200, 500, 95, 30);




