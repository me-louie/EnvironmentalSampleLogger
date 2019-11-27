package ui.gui;

import model.BoreholeLog;
import model.Observable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;

import static javax.swing.SwingConstants.*;


public class BoreholeLoggerUI extends Observable {

    private int width = 25;
    private int height = width;
    private BoreholeLog bh = BoreholeLog.getInstance();

    private String[] colours = {"blue", "grey", "brown"};
    private String[] types = {"silt", "sand", "gravel"};
    private String[] odourous = {"no", "yes"};

    private JTextField sampleID = new JTextField("");
    private JLabel enterSampleData = new JLabel("Enter Sample Data");
    private JLabel myID = new JLabel("Sample ID");
    private JLabel myColour = new JLabel("Colour:");
    private JLabel myStratigraphy = new JLabel("Stratigraphy:");
    private JLabel myOdour = new JLabel("Odorous?");
    private JButton submitSample = new JButton("OK");

    private JTextField consoleLog = new JTextField("Welcome to Borehole Logger v.11.0!");

    private JComboBox jcc = new JComboBox(colours);
    private JComboBox jct = new JComboBox(types);
    private JComboBox jco = new JComboBox(odourous);

    private Color colour1 = new Color(252, 239, 236);
    private Color colour2 = new Color(200, 185, 150);

//    private ImageIcon augerIcon = new ImageIcon("data/Capture.PNG");


    //MODIFIES: this, BoreholeLogDrawer
    //EFFECTS: creates JFrame and adds buttons to frame to create app GUI
    public BoreholeLoggerUI() {

        JFrame frame = new JFrame();

        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocation(700, 50);
//        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1));

        JLabel appName = new JLabel("Borehole Logger");
        appName.setFont(new Font("Calibri", Font.BOLD, 35));
        consoleLog.setFont(new Font("Arial", Font.BOLD, 20));
        enterSampleData.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 20));
        reset.setBackground(colour2);
        reset.addActionListener(new ActionListener() {
            @Override
            //MODIFIES: this, BoreholeLogDrawer, BoreholeLog
            //EFFECTS: removes all existing samples from BoreholeLog and repaints BoreholeLogDrawer when resetButton
            //         is clicked
            public void actionPerformed(ActionEvent e) {
                BoreholeLogDrawer.getInstance().setNumOfSamples(0);
                bh.clear();
                consoleLog.setText("All samples were removed from the BoreholeLog.");
                BoreholeLogDrawer.getInstance().repaint();
            }
        });

        //creates Add Sample Button
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 25));
        addButton.setBackground(colour2);
        addButton.addActionListener(new ActionListener() {
            @Override
            //MODIFIES: this
            //EFFECTS: generates add sample menu pane when addButton is clicked
            public void actionPerformed(ActionEvent e) {
                generateAddSampleMenu();
            }
        });

        JButton removeButton = new JButton("-");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 35));
        removeButton.setBackground(colour1);
        removeButton.addActionListener(new ActionListener() {
            @Override
            //MODIFIES: this
            //EFFECTS: generates remove sample menu pane whe removeButton is clicked
            public void actionPerformed(ActionEvent e) {
                generateRemoveSampleMenu();
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 20));
        saveButton.setBackground(colour2);
        saveButton.addActionListener(new ActionListener() {
            @Override
            //MODIFIES: this, BoreholeLog
            //EFFECTS: saves current sample data to BoreholeLog when saveButton is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    generateSaveProjectMenu();
                } catch (FileNotFoundException | InvalidPathException ex) {
                    consoleLog.setForeground(Color.RED);
                    consoleLog.setText("ERROR: Sorry, that file name is invalid.");
//                    ex.printStackTrace();
                }
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setFont(new Font("Arial", Font.BOLD, 20));
        loadButton.setBackground(colour1);
        loadButton.addActionListener(new ActionListener() {
            @Override
            //MODIFIES: this, BoreholeLog, BoreholeLogDrawer
            //EFFECTS: loads saved BoreholeLog data and repaints BoreholeLogDrawer
            public void actionPerformed(ActionEvent e) {
                String m = JOptionPane.showInputDialog("Please enter a file name");
                try {
                    bh.load(m + ".txt");
                    BoreholeLogDrawer.getInstance().update(BoreholeLog.getInstance());
                    consoleLog.setForeground(Color.BLACK);
                    consoleLog.setText("File: '" + m + "' was successfully loaded.");
                } catch (FileNotFoundException | InvalidPathException ex) {
                    consoleLog.setForeground(Color.RED);
                    consoleLog.setText("Sorry, that file was not found.");
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
        consoleLog.setForeground(Color.BLACK);
        consoleLog.setText("File: '" + m + "' was successfully saved.");
    }

    private void generateRemoveSampleMenu() {
        String m = JOptionPane.showInputDialog("Please enter the ID of the sample you wish to delete");
        if (bh.isSampleIDUnique(m)) {
            consoleLog.setForeground(Color.RED);
            consoleLog.setText("ERROR: Sorry, that sample was not found.");
        } else {
            consoleLog.setForeground(Color.BLACK);
            bh.removeSampleFromLog(m);
            consoleLog.setText("Sample " + m + " was removed.");
        }
    }

    private void generateAddSampleMenu() {
        formatComboBoxes();
        submitSample.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = sampleID.getText();
                String selectedColour = jcc.getSelectedItem().toString();
                String selectedStrat = jct.getSelectedItem().toString();
                String selectedOdour = jco.getSelectedItem().toString();
                boolean odour = hasOdour(selectedOdour);
                makeSample(selectedID, selectedColour, selectedStrat, odour);
//                if (!bh.isSampleIDUnique(selectedID)) {
//                    consoleLog.setText("Sorry, that ID has already been used.");
//                } else {
//                    bh.addSoilSampleToLog(selectedID, selectedColour, selectedStrat, odour);
//                    consoleLog.setText("Sample " + selectedID + " was added.");
//                }
            }
        });

        Object[] options = new Object[]{};
        JOptionPane enterSampleInformation = new JOptionPane(enterSampleData, JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, options, null);

        generateComboBoxMenu(enterSampleInformation);

        //create a JDialog and add JOptionPane to it
        createJDialog(enterSampleInformation);
    }

    private void makeSample(String selectedID, String selectedColour, String selectedStrat, boolean odour) {

        if (!bh.isSampleIDUnique(selectedID)) {
            consoleLog.setForeground(Color.RED);
            consoleLog.setText("ERROR: Sorry, that ID has already been used.");
        } else {
            bh.addSampleToLog(selectedID, selectedColour, selectedStrat, odour);
            consoleLog.setForeground(Color.BLACK);
            consoleLog.setText("Sample " + selectedID + " was added.");
        }
    }

    private boolean hasOdour(String selectedOdour) {
        boolean odour = false;
        if (selectedOdour.equals("yes")) {
            odour = true;
        }
        return odour;
    }


    private void formatComboBoxes() {
        myID.setFont(new Font("Arial", Font.BOLD, 20));
        myID.setAlignmentX(LEFT);
        sampleID.setFont(new Font("Arial", Font.PLAIN, 20));

        myColour.setAlignmentX(LEFT);
        myColour.setFont(new Font("Arial", Font.BOLD, 20));
        jcc.setEditable(true);
        jcc.setFont(new Font("Arial", Font.PLAIN, 20));

        myStratigraphy.setAlignmentX(LEFT);
        myStratigraphy.setFont(new Font("Arial", Font.BOLD, 20));
        jct.setEditable(true);
        jct.setFont(new Font("Arial", Font.PLAIN, 20));

        myOdour.setAlignmentX(LEFT);
        myOdour.setFont(new Font("Arial", Font.BOLD, 20));
        jco.setEditable(true);
        jco.setFont(new Font("Arial", Font.PLAIN, 20));
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
