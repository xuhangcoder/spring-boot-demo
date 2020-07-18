package com.xuhang.springbootdemo.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author xuhang
 * @date 2020/4/9 19:11
 */
public class GUIFrame extends JFrame {
    private JButton button;
    private JLabel label;

    public GUIFrame() {
        String text;
        button = new JButton("登录");
        label = new JLabel("Hello word");
        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 500)/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 300)/2
                , 500, 300);
        setLayout(new FlowLayout());
        add(label);
        add(button);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUIFrame();
    }
}
