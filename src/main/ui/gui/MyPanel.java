package ui.gui;

import model.Observer;
import model.SoilSample;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class MyPanel extends JPanel implements Observer {

    private int xcoord = 200;
    private int ycoord = 50;
    private int squareW = 50;
    private int squareH = 50;
    private Color blue = new Color(105, 188, 200);
    private Color grey = new Color(105, 105, 105);
    private Color brown = new Color(150, 94, 27);
    private int numOfSamples = 0;
    private boolean toPaint = true;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(new Color(200, 190, 153));

//        addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                moveSquare(e.getX(), e.getY());
//            }
//        });
//
//        addMouseMotionListener(new MouseAdapter() {
//            public void mouseDragged(MouseEvent e) {
//                moveSquare(e.getX(), e.getY());
//            }
//        });

    }

//    private void moveSquare(int x, int y) {
//        int OFFSET = 1;
//        if ((squareX != x) || (squareY != y)) {
//            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
//            squareX = x;
//            squareY = y;
//            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
//        }
//    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        g.drawString("My Soil Samples", 10, 20);

        System.out.println("prior to loop");
//        while (numOfSamples != 0) {
        if (numOfSamples == 1) {
            g.fillRect(xcoord, ycoord, squareW, squareH);

        } else {
            g.fillOval(xcoord, ycoord, squareW, squareH);
        }

        System.out.println("we repainted.");


//        g.setColor(grey);
//        g.fillRect(xcoord, ycoord, squareW, squareH);
//        g.setColor(Color.BLACK);
//        g.drawRect(xcoord, ycoord, squareW, squareH);
//
//        g.setColor(blue);
//        g.fillRect(xcoord, ycoord + squareH, squareW, squareH);
//        g.setColor(Color.BLACK);
//        g.drawRect(xcoord, ycoord + squareH, squareW, squareH);
    }


    @Override
    public String update(SoilSample s) {
        numOfSamples++;
//        validate();
        this.repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("pause");
        }
        repaint();
        System.out.println("blah blah blah");
        String latestColour = s.getColour();
        return null;
    }
}


