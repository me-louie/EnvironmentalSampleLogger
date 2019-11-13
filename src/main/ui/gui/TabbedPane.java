package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class TabbedPane implements ActionListener {
    public static void main(String [] args) {
        TabPane tabbedPane = new TabPane();
    }

    private DefaultListModel model = new DefaultListModel();
    private JList list = new JList(model);
    private JPanel panel = new JPanel();
    private JFrame frame;


    public TabbedPane() {
        createFrame();
//        //creates new frame
//        JFrame frame = new JFrame("Environmental Sample Logger");
//
//        //sets frame properties
//        frame.setSize(500, 800);
//        frame.setLayout(null);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
////        JLabel welcomeMsg = new JLabel("Welcome to Borehole Logger v.10.0!");
////        welcomeMsg.setBounds(150, 200, 300, 50);
//
//        //sets grid layout for pane
//        frame.getContentPane().setLayout(new GridLayout(1, 1));
//
//        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//
//        tabbedPane.addTab("Soil", makePanel("Welcome to the Borehole Logger!"));
//        tabbedPane.addTab("Water", makePanel("Welcome to the Water Logger!"));
//
//        frame.getContentPane().add(tabbedPane);

//        model = new DefaultListModel();
//        list = new JList(model);


//        frame.add(createSampleList());
//        newSampleList();


//        frame.add(welcomeMsg);


    }

    private void createFrame() {
        frame = new JFrame("Environmental Sample Logger");

        //sets frame properties
        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JLabel welcomeMsg = new JLabel("Welcome to Borehole Logger v.10.0!");
//        welcomeMsg.setBounds(150, 200, 300, 50);

        //sets grid layout for pane
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        tabbedPane.addTab("Soil", makePanel("Welcome to the Borehole Logger!"));
        tabbedPane.addTab("Water", makePanel("Welcome to the Water Logger!"));

        frame.getContentPane().add(tabbedPane);

    }

    private void newSampleList() {

        JButton addButton = new JButton("Add new sample");
        addButton.setBounds(150, 600, 95, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addElement("Element x");
            }
        });
//        p.add(addButton);

//        DeleteButton deleteButton = new DeleteButton();
        JButton deleteButton = new JButton("Remove sample");
//        deleteButton.setActionCommand("button1");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed(e);
            }
        });
        addButton.setBounds(150, 650, 95, 30);

//        JPanel panel = new JPanel();
//        panel.setBounds(500, 600, 50, 60);
//        panel.add(new JScrollPane(list));
//        panel.add(deleteButton);
//        panel.add(addButton);

//        JOptionPane.showMessageDialog(null, p);
    }


    private JPanel makePanel(String text) {
//        JPanel p = new JPanel();
        panel.add(new Label(text));
//        p.setLayout(new GridLayout(1, 1));


//        JButton addButton = new JButton("Add new sample");
//        addButton.setBounds(150, 600, 95, 30);
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                model.addElement("Element x");
//            }
//        });
//        p.add(addButton);
//
////        DeleteButton deleteButton = new DeleteButton();
//        JButton deleteButton = new JButton("Remove sample");
//        deleteButton.setActionCommand("button1");
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                removeActionPerformed(e);
//            }
//        });
//        addButton.setBounds(150, 650, 95, 30);
//        p.add(deleteButton);
//        deleteButton.addActionListener(this);
        return panel;
    }

    private void removeActionPerformed(ActionEvent e) {
        System.out.println("made_list's model: " + list.getModel());
        System.out.println("Model from a fresh JList: " + new JList().getModel());
        DefaultListModel model = (DefaultListModel) list.getModel();
        if (model.size() > 0) {
            model.remove(0);
        }
    }


    //EFFECTS: create list of samples on side of frame
    private JList createSampleList() {
        DefaultListModel sampleList = new DefaultListModel();
        sampleList.addElement("Test1");
        sampleList.addElement("Test2");
        sampleList.addElement("Test3");

        this.list = new JList(sampleList);
        return this.list;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

//    public void actionPerformed(ActionEvent e) {
////        int index = this.list.getSelectedIndex();
//        if (e.getActionCommand().equals("button2")) {
//            list.addElement("New Item");
//        }
//    }


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




