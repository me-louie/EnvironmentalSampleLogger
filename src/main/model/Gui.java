package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Gui {
    public static void main(String args[]) {
        Gui gui = new Gui();
    }

    public Gui() {

        JFrame frame = new JFrame("Borehole Log App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeMsg = new JLabel("Welcome to Borehole Logger v.10.0!");
        welcomeMsg.setBounds(150, 50, 300, 50);

        JLabel selectSampleType = new JLabel("What type of sample would you like to access?");
        selectSampleType.setBounds(150, 100, 300, 50);

        JButton b1 = new JButton("Soil");
        b1.setBounds(200, 300, 95, 30);

        JButton b2 = new JButton("Water");
        b2.setBounds(200, 500, 95, 30);

        frame.add(welcomeMsg);
        frame.add(selectSampleType);
        frame.add(b1);
        frame.add(b2);

        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setVisible(true);
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

//
//        JFrame frame = new JFrame("Borehole Log App");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 800);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(new Color(51, 123, 100));
//        panel.setVisible(true);
//
//        JButton button = new JButton("enter");
////        button.setSize(200, 100);
////        button.setBounds(300,100,500, 80);
//        JTextField textField = new JTextField();
//        textField.setBounds(50,50, 150,20);
//
//        button.setVisible(true);
//        panel.add(button);
//        panel.add(textField);
//
//        frame.add(panel);
//        frame.setVisible(true);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(new Color(77, 103, 123));
//        panel.setVisible(true);
//
//        JButton enter = new JButton("Enter");
//        JLabel label = new JLabel("This is a enter button");
//
//        panel.add(enter);
//        panel.add(label);
//
//        frame.add(panel);


//
//        JButton button1 = new JButton("Button 1");
//        JButton button2 = new JButton("Button 2");
//        JLabel yellowLabel = new JLabel();
//        yellowLabel.setOpaque(true);
//        yellowLabel.setBackground(new Color(248, 213, 131));
//        yellowLabel.setPreferredSize(new Dimension(50, 50));
//        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
////        frame.getContentPane().add(button2);
//        frame.setVisible(true);




