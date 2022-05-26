package com.kuang.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo()  {
        //获取图片的地址
        JLabel label = new JLabel("ImageIcon");
        URL url = ImageIconDemo.class.getResource("xxx.jpg");//获取当前类以下的东西

        ImageIcon imageIcon = new ImageIcon(url);//命名不要冲突
        //给label设置一个图标
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container contentPane = getContentPane();
        contentPane.add(label);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,300,500);
    }
    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
