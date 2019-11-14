package ui.gui;

import sun.java2d.loops.DrawRect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Graphic extends JPanel {

    private int width = 25;
    private int height = width;
//    private MyPanel panel = MyPanel.getInstance();


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
                MyPanel.getInstance().repaint();
            }
        });

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                JPanel createNewSamplePanel = new JPanel(new GridLayout());
//                JButton blue = new JButton("blue");
//                JButton grey = new JButton("grey");
//                JButton brown = new JButton("brown");
//                createNewSamplePanel.add(blue);
//                createNewSamplePanel.add(grey);
//                createNewSamplePanel.add(brown);
                JLabel myColour = new JLabel("Colour:");
                JLabel myStratigraphy = new JLabel("Stratigraphy:");
                JLabel myOdour = new JLabel("Is the sample odorous?");

                String[] colours = {"Blue", "Grey", "Brown"};
                String[] types = {"Silt", "Sand", "Gravel"};
                String[] odourous = {"No", "Yes"};

                JComboBox jcc = new JComboBox(colours);
                JComboBox jct = new JComboBox(types);
                JComboBox jco = new JComboBox(odourous);

                jcc.setEditable(true);
                jct.setEditable(true);
                jco.setEditable(true);

                Object[] options = new Object[]{};
                JOptionPane createSample = new JOptionPane("Enter Sample Information", JOptionPane.QUESTION_MESSAGE,
                        JOptionPane.OK_CANCEL_OPTION, null, options, null);

                createSample.add(myColour);
                createSample.add(jcc);
                createSample.add(myStratigraphy);
                createSample.add(jct);
                createSample.add(myOdour);
                createSample.add(jco);

                //create a JDialog and add JOptionPane to it
                JDialog diag = new JDialog();
                diag.getContentPane().add(createSample);
                diag.pack();
                diag.setVisible(true);


//                String input = (String) JOptionPane.showInputDialog(null, "Select Colour",
//                        "Create a new sample", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

//                JOptionPane newSampleWindow = new JOptionPane("Enter sample information",
//                        JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
//
//
//
//                JDialog dialog = newSampleWindow.createDialog("Create New Sample");
//                dialog.setVisible(true);


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

    //create JOption Pane
    // take user input -> assign

}
