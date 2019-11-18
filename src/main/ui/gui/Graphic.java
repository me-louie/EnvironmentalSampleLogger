package ui.gui;

import model.BoreholeLog;
import model.Observable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import static javax.swing.SwingConstants.LEFT;


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
    private JLabel myColour = new JLabel("Colour:", LEFT);
    private JLabel myStratigraphy = new JLabel("Stratigraphy:");
    private JLabel myOdour = new JLabel("Is the sample odorous?");
    private JButton submitSample = new JButton("OK");

    public JTextField consoleLog = new JTextField("Status...");

    private JComboBox jcc = new JComboBox(colours);
    private JComboBox jct = new JComboBox(types);
    private JComboBox jco = new JComboBox(odourous);

    private Color darkBlue = new Color(70, 160, 252);
    private Color lightBlue = new Color(143, 185, 200);


//    private void formatFields() {
//        ArrayList<JLabel> labels = new ArrayList<>();
//        labels.addAll(Arrays.asList(myID, myColour, myStratigraphy, myOdour));
//
//        for (int i = 0; i < labels.size(); i++) {
//            setFont(new Font("Arial", Font.PLAIN, 20));
//            setAlignmentX(RIGHT_ALIGNMENT);
//        }

//    }


    public static void main(String[] args) {
        Graphic g = new Graphic();
    }

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
        reset.setBackground(lightBlue);
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
        addButton.setFont(new Font("Arial", Font.BOLD, 30));
//        addButton.setForeground(Color.WHITE);
        addButton.setBackground(lightBlue);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAddSamplePane();
            }
        });

        JButton removeButton = new JButton("-");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 35));
        removeButton.setBackground(darkBlue);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRemoveSamplePane();
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 20));
        saveButton.setBackground(lightBlue);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createSavePanel();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    consoleLog.setText("Sorry, that file name is invalid.");
                }

            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setFont(new Font("Arial", Font.BOLD, 20));
        loadButton.setBackground(darkBlue);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = JOptionPane.showInputDialog("Please enter a file name");
                try {
                    bh.load(m + ".txt");
                    MyPanel.getInstance().update(BoreholeLog.getInstance());
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
        frame.add(MyPanel.getInstance(), BorderLayout.CENTER);
        frame.add(consoleLog, BorderLayout.PAGE_END);

        frame.pack();

    }

    private void createSavePanel() throws FileNotFoundException {
        String m = JOptionPane.showInputDialog("Please enter a file name");
        bh.save(m + ".txt");
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
                boolean odour = false;
                if (selectedOdour.equals("true")) {
                    odour = true;
                }
                bh.addSoilSampleToLog(selectedID, selectedColour, selectedStrat, odour);


            }
        });

        Object[] options = new Object[]{};
        JOptionPane addSamplePane = new JOptionPane("Enter Sample Information", JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, options, null);


        createPanel(addSamplePane);
//        addSamplePane.add(myID);
//        addSamplePane.add(sampleID);
//        addSamplePane.add(myColour);
//        addSamplePane.add(jcc);
//        addSamplePane.add(myStratigraphy);
//        addSamplePane.add(jct);
//        addSamplePane.add(myOdour);
//        addSamplePane.add(jco);
//        addSamplePane.add(submitSample);

        //create a JDialog and add JOptionPane to it
        createDialog(addSamplePane);
//        JDialog diag = new JDialog();
//        diag.getContentPane().add(addSamplePane);
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
//        myID.setAlignmentX(RIGHT_ALIGNMENT);
//        myID.setFont(new Font("Arial", Font.BOLD, 20));
        jp.add(myID);
        jp.add(sampleID);

//        myColour.setAlignmentX(LEFT_ALIGNMENT);
//        myColour.setFont(new Font("Arial", Font.BOLD, 20));
        jp.add(myColour);
        jp.add(jcc);
//        myStratigraphy.setAlignmentX(RIGHT_ALIGNMENT);
        jp.add(myStratigraphy);
        jp.add(jct);
//        myOdour.setAlignmentX(RIGHT_ALIGNMENT);
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
