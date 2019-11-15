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



    public static void main(String[] args) {
        Graphic g = new Graphic();
    }

    public Graphic() {
        JFrame frame = new JFrame();

        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());
//        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel header = new JLabel("Borehole Logger");
//        JPanel buttonPanel = new JPanel(new GridLayout(15, 1));

        JPanel buttonPanel = new JPanel(new FlowLayout());
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

        buttonPanel.add(header);
        buttonPanel.add(reset);
        buttonPanel.add(addButton);
//
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);

//
        frame.add(buttonPanel, BorderLayout.PAGE_START);
        frame.add(MyPanel.getInstance(), BorderLayout.CENTER);
//        frame.add(buttonPanel, BorderLayout.LINE_END);

        frame.pack();

    }

    public void createAddSamplePane() {
        JTextField sampleID = new JTextField("");
        JLabel myID = new JLabel("Please enter a sample ID");
        JLabel myColour = new JLabel("Colour:");
        JLabel myStratigraphy = new JLabel("Stratigraphy:");
        JLabel myOdour = new JLabel("Is the sample odorous?");

        String[] colours = {"blue", "grey", "brown"};
        String[] types = {"silt", "sand", "gravel"};
        String[] odourous = {"no", "yes"};

        JComboBox jcc = new JComboBox(colours);
        JComboBox jct = new JComboBox(types);
        JComboBox jco = new JComboBox(odourous);

        jcc.setEditable(true);
        jct.setEditable(true);
        jco.setEditable(true);

        JButton submitSample = new JButton("OK");
        submitSample.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = sampleID.getText();
                String selectedColour = jcc.getSelectedItem().toString();
                String selectedStrat = jct.getSelectedItem().toString();
                String selectedOdour = jco.getSelectedItem().toString();
                bh.addSoilSampleToLog(selectedID, selectedColour, selectedStrat, true);





                System.out.println(selectedID);
                System.out.println(selectedColour + " was selected.");
                System.out.println(selectedStrat + " was selected.");
                System.out.println(selectedOdour + " was selected.");
            }
        });

        Object[] options = new Object[]{};
        JOptionPane createSample = new JOptionPane("Enter Sample Information", JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, options, null);

        createSample.add(myID);
        createSample.add(sampleID);
        createSample.add(myColour);
        createSample.add(jcc);
        createSample.add(myStratigraphy);
        createSample.add(jct);
        createSample.add(myOdour);
        createSample.add(jco);
        createSample.add(submitSample);

        //create a JDialog and add JOptionPane to it
        JDialog diag = new JDialog();
        diag.getContentPane().add(createSample);
        diag.pack();
        diag.setVisible(true);
    }

}
