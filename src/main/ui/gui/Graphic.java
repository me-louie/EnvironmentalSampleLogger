package ui.gui;

import model.BoreholeLog;
import model.Observable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import static javax.swing.SwingConstants.*;


public class Graphic extends Observable {

    private int width = 25;
    private int height = width;
    private BoreholeLog bh = BoreholeLog.getInstance();

    private String[] colours = {"blue", "grey", "brown"};
    private String[] types = {"silt", "sand", "gravel"};
    private String[] odourous = {"no", "yes"};

    private JTextField sampleID = new JTextField("");
    private JLabel enterSampleData = new JLabel("Enter Sample Data");
    private JLabel myID = new JLabel("Sample ID");
    //        myID.setAlignmentX(RIGHT_ALIGNMENT);
    private JLabel myColour = new JLabel("Colour:", LEFT);
    private JLabel myStratigraphy = new JLabel("Stratigraphy:");
    private JLabel myOdour = new JLabel("Is the sample odorous?");
    private JButton submitSample = new JButton("OK");

    private JTextField consoleLog = new JTextField("Status...");

    private JComboBox jcc = new JComboBox(colours);
    private JComboBox jct = new JComboBox(types);
    private JComboBox jco = new JComboBox(odourous);

    private Color colour1 = new Color(252, 239, 236);
    private Color colour2 = new Color(200, 185, 150);

    private ImageIcon augerIcon = new ImageIcon("data/Capture.PNG");



    //MODIFIES: this
    //EFFECTS: creates JFrame and adds buttons to frame to create app GUI
    public Graphic() {

        JFrame frame = new JFrame();

        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1));

        JLabel appName = new JLabel("Borehole Logger");
        appName.setFont(new Font("Calibri", Font.BOLD, 35));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 20));
        reset.setBackground(colour2);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoreholeLogDrawer.getInstance().setNumOfSamples(0);
                bh.clear();
                BoreholeLogDrawer.getInstance().repaint();
            }
        });

        //creates Add Sample Button
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 25));
        addButton.setBackground(colour2);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateAddSampleMenu();
            }
        });

        JButton removeButton = new JButton("-");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 35));
        removeButton.setBackground(colour1);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRemoveSampleMenu();
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 20));
        saveButton.setBackground(colour2);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    generateSaveProjectMenu();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    consoleLog.setText("Sorry, that file name is invalid.");
                }

            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setFont(new Font("Arial", Font.BOLD, 20));
        loadButton.setBackground(colour1);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = JOptionPane.showInputDialog("Please enter a file name");
                try {
                    bh.load(m + ".txt");
                    BoreholeLogDrawer.getInstance().update(BoreholeLog.getInstance());
                } catch (FileNotFoundException ex) {
//                    ex.printStackTrace();
                }

            }
        });


        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(reset);

        headerPanel.add(appName);
        headerPanel.add(buttonPanel);

        frame.add(headerPanel, BorderLayout.PAGE_START);
        frame.add(BoreholeLogDrawer.getInstance(), BorderLayout.CENTER);
        frame.add(consoleLog, BorderLayout.PAGE_END);

        frame.pack();

    }


    private void generateSaveProjectMenu() throws FileNotFoundException {
        String m = JOptionPane.showInputDialog("Please enter a file name");
        bh.save(m + ".txt");
    }

    private void generateRemoveSampleMenu() {
        String m = JOptionPane.showInputDialog("Please enter the ID of the sample you wish to delete");
        bh.removeSampleFromLog(m);
    }

    private void generateAddSampleMenu() {
        setComboBoxesEditable();
        submitSample.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = sampleID.getText();
                String selectedColour = jcc.getSelectedItem().toString();
                String selectedStrat = jct.getSelectedItem().toString();
                String selectedOdour = jco.getSelectedItem().toString();
                boolean odour = hasOdour(selectedOdour);
                bh.addSoilSampleToLog(selectedID, selectedColour, selectedStrat, odour);
            }
        });

        Object[] options = new Object[]{};
        JOptionPane enterSampleInformation = new JOptionPane(enterSampleData, JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, options, null);

        generateComboBoxMenu(enterSampleInformation);

        //create a JDialog and add JOptionPane to it
        createJDialog(enterSampleInformation);
    }

    private boolean hasOdour(String selectedOdour) {
        boolean odour = false;
        if (selectedOdour.equals("yes")) {
            odour = true;
        }
        return odour;
    }


    private void setComboBoxesEditable() {
        jcc.setEditable(true);
        jcc.setPreferredSize(new Dimension(1, 30));
        jct.setEditable(true);
        jct.setPreferredSize(new Dimension(1, 30));
        jco.setEditable(true);
        jco.setPreferredSize(new Dimension(1, 30));
    }


    private void generateComboBoxMenu(JOptionPane jp) {
        jp.add(myID);
        jp.add(sampleID);

        jp.add(myColour);
        jp.add(jcc);

        jp.add(myStratigraphy);
        jp.add(jct);

        jp.add(myOdour);
        jp.add(jco);
        jp.add(submitSample);

    }

    private void createJDialog(JOptionPane createSample) {
        JDialog diag = new JDialog();
        diag.getContentPane().add(createSample);
        diag.pack();
        diag.setVisible(true);
        diag.setLocation(1200, 300);
    }

}
