package ui.gui;


import java.awt.event.*;
import javax.swing.*;

public class Foo1 {
    private String[] elements = {"Monday", "Tueday", "Wednesday"};
    private javax.swing.JList madeList = new javax.swing.JList();

    //
    public Foo1() {
        madeList.setModel(new DefaultListModel());
        for (String element : elements) {
            ((DefaultListModel) madeList.getModel()).addElement(element);
        }

        JButton removeItemBtn = new JButton("Remove Item");
        removeItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed(e);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(madeList));
        panel.add(removeItemBtn);

        JOptionPane.showMessageDialog(null, panel);
    }

    private void removeActionPerformed(ActionEvent e) {
        System.out.println("made_list's model: " + madeList.getModel());
        System.out.println("Model from a fresh JList: " + new JList().getModel());
        DefaultListModel model = (DefaultListModel) madeList.getModel();
        if (model.size() > 0) {
            model.remove(0);
        }
    }

    public static void main(String[] args) {
        new Foo1();
    }

}
