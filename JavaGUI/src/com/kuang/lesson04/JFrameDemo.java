package com.kuang.lesson04;

import javax.swing.*;
import java.awt.*;
public class JFrameDemo {
    //init();初始化
    public void init(){
        //顶级窗口
        JFrame jf = new JFrame("这是一个JFrame窗口");
        jf.setVisible(true);
        //jf.setBackground(Color.cyan);     因为在容器中，直接颜色没效果，需要容器实例化
        jf.setBounds(100,100,200,200);
        JLabel jLabel = new JLabel("欢迎来到狂神说Java系列节目");  //标签
        jf.add(jLabel);
        //让文本标签居中，设置水平对齐
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //需要容器实例化,颜色才能现象
        //jf.setBackground(Color.blue);没用
        //Container contentPane = jf.getContentPane();
        //contentPane.setBackground(Color.cyan);
        //关闭事件
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}
