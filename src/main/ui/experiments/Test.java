package ui.experiments;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    private JFrame frame;

    public static void main(String[] args) {
        Test test = new Test();
    }

    public Test() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setSize(400, 400);
        mainPanel.setBackground(Color.PINK);
        frame.add(mainPanel);

    }
}
