package ui.gui;

import model.BoreholeLog;
import model.Observer;
import model.SoilSample;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements Observer {

    private int xcoord = 200;
    private int ycoord = 50;
    private int squareW = 50;
    private int squareH = 50;
    private Color blue = new Color(105, 188, 200);
    private Color grey = new Color(105, 105, 105);
    private Color brown = new Color(150, 94, 27);
    private int numOfSamples = 0;
    private static final MyPanel INSTANCE = new MyPanel();

    private List<Color> sampleColours;
    private List<String> sampleIDs = new ArrayList<>();
    private BoreholeLog boreholeLog = BoreholeLog.getInstance();


    private MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(new Color(192, 200, 158));
        sampleColours = new ArrayList<>();

    }

    public static MyPanel getInstance() {
        return INSTANCE;
    }

//    public MyPanel() {
//        System.out.println("Made new panel");
//        setBorder(BorderFactory.createLineBorder(Color.black));
//        setBackground(new Color(200, 190, 153));
//
////        addMouseListener(new MouseAdapter() {
////            public void mousePressed(MouseEvent e) {
////                moveSquare(e.getX(), e.getY());
////            }
////        });
////
////        addMouseMotionListener(new MouseAdapter() {
////            public void mouseDragged(MouseEvent e) {
////                moveSquare(e.getX(), e.getY());
////            }
////        });
//
//    }

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

        g.setFont(new Font("Calibri", Font.BOLD, 25));
        g.drawString("Sample IDs", 20, 40);


        for (int i = 0; i < numOfSamples; i++) {
            g.setColor(sampleColours.get(i));
            g.fillRect(xcoord, ycoord + i * squareW, squareW, squareH);
            if (boreholeLog.getSample(i).isOdourous()) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawRect(xcoord, ycoord + i * squareW, squareW, squareH);
            g.drawString(boreholeLog.getSample(i).getName(), xcoord - 100, (ycoord + 25) + i * squareW);
        }

    }


    @Override
    public String update(BoreholeLog boreholeLog) {
        numOfSamples = boreholeLog.logSize();
        sampleColours.clear();
//        sampleIDs.clear();
        this.boreholeLog = boreholeLog;
        for (int i = 0; i < numOfSamples; i++) {
            Color clr = parseColor(boreholeLog.getSample(i).getColour());
            sampleColours.add(clr);
//            sampleIDs.add(boreholeLog.getSample(i).getName());
        }
        repaint();
        return null;


    }

    private Color parseColor(String clr) {
        if (clr.equals("blue")) {
            return blue;
        } else if (clr.equals("grey")) {
            return grey;
        } else {
            return brown;
        }
    }

    protected void setNumOfSamples(int i) {
        numOfSamples = i;
    }
}



