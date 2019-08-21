package java.com.yh.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    private JScrollPane jScrollPane;
    private JTextField jTextField;

    public MyMouseListener(JScrollPane jScrollPane, JTextField jTextField) {
        this.jScrollPane = jScrollPane;
        this.jTextField = jTextField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JTextArea tmp = (JTextArea) jScrollPane.getComponent(0).getComponentAt(new Point(0, 1));
        if (e.getSource() == jTextField && jTextField.getText().contains("输入")) {
            jTextField.setText("");
        } else if (e.getSource() == jScrollPane
                && tmp.getText().contains("输入")) {
            tmp.setText("");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}