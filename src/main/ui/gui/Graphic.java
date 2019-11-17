package ui.gui;

import model.BoreholeLog;
import model.Observable;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Graphic extends Observable {

    private int width = 25;
    private int height = width;
    private BoreholeLog bh = BoreholeLog.getInstance();

    private String[] colours = {"blue", "grey", "brown"};
    private String[] types = {"silt", "sand", "gravel"};
    private String[] odourous = {"no", "yes"};

    private JTextField sampleID = new JTextField("");
    private JLabel myID = new JLabel("Please enter a sample ID");
    //        myID.setAlignmentX(RIGHT_ALIGNMENT);
    private JLabel myColour = new JLabel("Colour:");
    private JLabel myStratigraphy = new JLabel("Stratigraphy:");
    private JLabel myOdour = new JLabel("Is the sample odorous?");
    private JButton submitSample = new JButton("OK");

    private JComboBox jcc = new JComboBox(colours);
    private JComboBox jct = new JComboBox(types);
    private JComboBox jco = new JComboBox(odourous);


    public static void main(String[] args) {
        Graphic g = new Graphic();
    }

    public Graphic() {
        JFrame frame = new JFrame();

        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());
//        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1));


        JLabel header = new JLabel("Borehole Logger");
        header.setFont(new Font("Calibri", Font.BOLD, 25));
//        JPanel buttonPanel = new JPanel(new GridLayout(15, 1));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyPanel.getInstance().setNumOfSamples(0);
                bh.clear();
                MyPanel.getInstance().repaint();
            }
        });

        //creates Add Sample Button
        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAddSamplePane();
            }
        });

        JButton removeButton = new JButton("-");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRemoveSamplePane();
            }
        });



        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(reset);

        headerPanel.add(header);
        headerPanel.add(buttonPanel);
//
//        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
//        centerPanel.setBackground(Color.YELLOW);
//        centerPanel.add(buttonPanel);
//        centerPanel.add(MyPanel.getInstance());
//        panel.add(buttonPanel, MyPanel.getInstance());
//        panel.setBackground(Color.YELLOW);

//
        frame.add(headerPanel, BorderLayout.PAGE_START);
        frame.add(MyPanel.getInstance(), BorderLayout.CENTER);
//        frame.add(buttonPanel, BorderLayout.LINE_END);

        frame.pack();

    }

    private void createRemoveSamplePane() {
        String m = JOptionPane.showInputDialog("Please enter the ID of the sample you wish to delete");
        bh.removeSampleFromLog(m);
    }

    public void createAddSamplePane() {
        jcc.setEditable(true);
        jct.setEditable(true);
        jco.setEditable(true);

        submitSample.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = sampleID.getText();
                String selectedColour = jcc.getSelectedItem().toString();
                String selectedStrat = jct.getSelectedItem().toString();
                String selectedOdour = jco.getSelectedItem().toString();
                bh.addSoilSampleToLog(selectedID, selectedColour, selectedStrat, true);


            }
        });

        Object[] options = new Object[]{};
        JOptionPane createSample = new JOptionPane("Enter Sample Information", JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, options, null);

        createPanel(createSample);
//        createSample.add(myID);
//        createSample.add(sampleID);
//        createSample.add(myColour);
//        createSample.add(jcc);
//        createSample.add(myStratigraphy);
//        createSample.add(jct);
//        createSample.add(myOdour);
//        createSample.add(jco);
//        createSample.add(submitSample);

        //create a JDialog and add JOptionPane to it
        createDialog(createSample);
//        JDialog diag = new JDialog();
//        diag.getContentPane().add(createSample);
//        diag.pack();
//        diag.setVisible(true);
    }

//    public void addSampleAL(JButton button){
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selectedID = sampleID.getText();
//                String selectedColour = jcc.getSelectedItem().toString();
//                String selectedStrat = jct.getSelectedItem().toString();
//                String selectedOdour = jco.getSelectedItem().toString();
//                bh.addSoilSampleToLog(selectedID, selectedColour, selectedStrat, true);
//
//
////                System.out.println(selectedID);
////                System.out.println(selectedColour + " was selected.");
////                System.out.println(selectedStrat + " was selected.");
////                System.out.println(selectedOdour + " was selected.");
//            }
//        });
//
//    }

    private JOptionPane createPanel(JOptionPane jp) {

        jp.add(myID);
        jp.add(sampleID);
        jp.add(myColour);
        jp.add(jcc);
        jp.add(myStratigraphy);
        jp.add(jct);
        jp.add(myOdour);
        jp.add(jco);
        jp.add(submitSample);
        return jp;
    }

    private Dialog createDialog(JOptionPane createSample) {
        JDialog diag = new JDialog();
        diag.getContentPane().add(createSample);
        diag.pack();
        diag.setVisible(true);
        diag.setLocation(1200, 300);
        return diag;
    }

}
