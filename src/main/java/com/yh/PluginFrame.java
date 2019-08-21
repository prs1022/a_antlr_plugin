package java.com.yh;

import com.intellij.openapi.components.ApplicationComponent;
import main.java.com.yh.listener.MyKeyListener;
import main.java.com.yh.listener.MyMouseListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class PluginFrame implements ApplicationComponent {

    public void drawWindow() {
        JFrame jFrame = new JFrame("窗口");

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.BLUE);
        jPanel.setBounds(new Rectangle(50, 50, 100, 50));
        jPanel.setLayout(new GridLayout(2, 1));

        jFrame.add(jPanel);
        JTextArea jta = new JTextArea("输入SQL", 3, 1);
        jta.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jta);
        jPanel.add(jScrollPane, 0);
        JTextField jtf = new JTextField("输入DSL", 50);
        jPanel.add(jtf, 1);

        //添加监听事件
        MyMouseListener mouseListener = new MyMouseListener(jScrollPane, jtf);
        MyKeyListener keyListener = new MyKeyListener(jta, jtf);
        jScrollPane.addMouseListener(mouseListener);
        jtf.addMouseListener(mouseListener);
        jtf.addKeyListener(keyListener);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new PluginFrame().drawWindow();
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "PluginFrame";
    }

}



