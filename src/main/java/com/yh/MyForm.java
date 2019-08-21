package java.com.yh;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyForm implements ApplicationComponent {

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "myForm";
    }

    public JFrame show() {
        JFrame frame = new JFrame("MyPlugin");
        frame.setContentPane(new MyForm().panel1);
        //        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭后IDE也会关闭
        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width / 2; // 获取屏幕的宽
        int screenHeight = screenSize.height / 2; // 获取屏幕的高
        frame.setLocation(screenWidth - frame.getWidth() / 2, screenHeight - frame.getHeight() / 2);
        sql_scroll.add(sql_content);
        dsl_scroll.add(dsl_content);
        frame.add(sql_scroll);
        frame.add(dsl_scroll);
        frame.add(execute);
        execute.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String sql = ((JTextArea) sql_scroll.getComponent(0)).getText();
                String dsl = ((JTextField) dsl_scroll.getComponent(0)).getText();
                System.out.println("sql文本:" + sql);
                System.out.println("dsl文本:" + dsl);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //放在线程实现，不阻塞UI刷新线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sql_content.setText("这里显示高亮的文本");
                    }
                }).start();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private void addListener() {
    }

    public static void main(String[] args) {
        MyForm form = new MyForm();
        JPanel panel = form.createPanel();
        JFrame jFrame = new JFrame("计算器");
        jFrame.add(panel);
        jFrame.pack();
        jFrame.setVisible(true);
    }


    private JPanel createPanel() {
        JPanel panel = new JPanel();

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbs = new GridBagConstraints();
        panel.setLayout(gbl);


        JButton bt7 = new JButton("7");
        JButton bt6 = new JButton("6");
        JButton bt5 = new JButton("5");
        JButton bt4 = new JButton("4");
        JButton bt3 = new JButton("3");
        JButton bt2 = new JButton("2");
        JButton bt1 = new JButton("1");
        JButton bt0 = new JButton("0");
        JButton bt8 = new JButton("8");
        JButton bt9 = new JButton("9");
        JButton bt10 = new JButton("10");
        JButton bt11 = new JButton("11");
        JButton bt12 = new JButton("12");
        JButton btp = new JButton("btp");
        JButton btm = new JButton("btm");
        JButton btdot = new JButton("btdot");
        JButton btsignleft = new JButton("btleft");
        JButton btsignright = new JButton("btright");
        JButton bte = new JButton("bte");
        JButton btmp = new JButton("btmp");
        JButton btclear = new JButton("clear");
        JButton btd = new JButton("btd");
        JButton bt = new JButton("bt");
        JTextField textField = new JTextField();
        panel.add(bt7);
        panel.add(bt8);
        panel.add(bt9);
        panel.add(btp);
        panel.add(bt4);
        panel.add(bt5);
        panel.add(bt6);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt9);
        panel.add(btp);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(btm);
        panel.add(bt0);
        panel.add(btdot);
        panel.add(btsignleft);
        panel.add(btsignright);
        panel.add(bte);
        panel.add(btmp);
        panel.add(btclear);
        panel.add(bt);
        panel.add(btd);
        panel.add(textField);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 0;
        gbl.setConstraints(bt7, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 1;
        gbs.gridy = 0;
        gbl.setConstraints(bt8, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 2;
        gbs.gridy = 0;
        gbl.setConstraints(bt9, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 2;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 3;
        gbs.gridy = 0;
        gbl.setConstraints(btp, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 1;
        gbl.setConstraints(bt4, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 1;
        gbs.gridy = 1;
        gbl.setConstraints(bt5, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 2;
        gbs.gridy = 1;
        gbl.setConstraints(bt6, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 2;
        gbl.setConstraints(bt1, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 1;
        gbs.gridy = 2;
        gbl.setConstraints(bt2, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 2;
        gbs.gridy = 2;
        gbl.setConstraints(bt3, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 2;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 3;
        gbs.gridy = 2;
        gbl.setConstraints(btm, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 2;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 3;
        gbl.setConstraints(bt0, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 2;
        gbs.gridy = 3;
        gbl.setConstraints(btdot, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 4;
        gbl.setConstraints(btsignleft, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 1;
        gbs.gridy = 4;
        gbl.setConstraints(btsignright, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 2;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 2;
        gbs.gridy = 4;
        gbl.setConstraints(bte, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 3;
        gbs.gridy = 4;
        gbl.setConstraints(btmp, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 5;
        gbl.setConstraints(btclear, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 1;
        gbs.gridy = 5;
        gbl.setConstraints(bt, gbs);
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 1;
        gbs.gridheight = 1;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 3;
        gbs.gridy = 5;
        gbl.setConstraints(btd, gbs);

        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridwidth = 4;
        gbs.gridheight = 3;
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.gridx = 0;
        gbs.gridy = 6;
        gbl.setConstraints(textField, gbs);

        return panel;
    }

    private JPanel panel1;
    private JTextArea sql_content;
    private JTextField dsl_content;
    private JButton execute;
    private JScrollPane dsl_scroll;
    private JScrollPane sql_scroll;


    public String run() {
        String sql = sql_content.getText();
        String dsl = dsl_content.getText();
        System.out.println("sql=>" + sql);
        System.out.println("dsl=>" + dsl);
        return null;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setAlignmentX(0.5f);
        panel1.setAutoscrolls(false);
        panel1.setBackground(new Color(-12209090));
        panel1.setEnabled(true);
        panel1.setMinimumSize(new Dimension(0, 0));
        panel1.setPreferredSize(new Dimension(530, 350));
        panel1.setToolTipText("语法高亮插件");
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-4473925)), null, TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, -1, panel1.getFont()), new Color(-4473925)));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Consolas", Font.BOLD, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setRequestFocusEnabled(true);
        label1.setText("antlr plugin");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel1.add(label1, gbc);
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, Font.PLAIN, 14, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setPreferredSize(new Dimension(120, 19));
        label2.setText("输入sql");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setPreferredSize(new Dimension(120, 17));
        label3.setText("输入dsl");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label3, gbc);
        dsl_scroll = new JScrollPane();
        dsl_scroll.setHorizontalScrollBarPolicy(31);
        dsl_scroll.setMinimumSize(new Dimension(0, 0));
        dsl_scroll.setOpaque(false);
        dsl_scroll.setPreferredSize(new Dimension(120, 100));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(dsl_scroll, gbc);
        dsl_content = new JTextField();
        dsl_content.setOpaque(true);
        dsl_content.setPreferredSize(new Dimension(120, 100));
        dsl_content.setRequestFocusEnabled(true);
        dsl_scroll.setViewportView(dsl_content);
        sql_scroll = new JScrollPane();
        sql_scroll.setAutoscrolls(true);
        sql_scroll.setInheritsPopupMenu(false);
        sql_scroll.setMaximumSize(new Dimension(900, 900));
        sql_scroll.setMinimumSize(new Dimension(0, 0));
        sql_scroll.setOpaque(false);
        sql_scroll.setPreferredSize(new Dimension(120, 100));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(sql_scroll, gbc);
        sql_content = new JTextArea();
        sql_content.setEnabled(true);
        sql_content.setLineWrap(true);
        sql_content.setMaximumSize(new Dimension(20, 100));
        sql_content.setMinimumSize(new Dimension(20, 19));
        sql_content.setPreferredSize(new Dimension(120, 100));
        sql_content.setWrapStyleWord(false);
        sql_scroll.setViewportView(sql_content);
        execute = new JButton();
        execute.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(execute, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
