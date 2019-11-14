package ui.gui;

import sun.java2d.loops.DrawRect;

import javax.swing.*;
import java.awt.*;


public class Graphic extends JPanel {

    private int width = 25;
    private int height = width;


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
//
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.YELLOW);
//
        frame.add(header, BorderLayout.PAGE_START);
        frame.add(new MyPanel(), BorderLayout.CENTER);

        frame.pack();

    }

}
