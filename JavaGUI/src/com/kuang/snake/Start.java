package com.kuang.snake;

import javax.swing.*;

public class Start {
    public static void main(String[] args) {
        JFrame frame=new JFrame();

        frame.setBounds(10,10,900,720);//初始位置,窗口大小

        frame.setResizable(false);//窗口大小不可变
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//可以被关闭

        //正常游戏界面在面板上
        frame.add(new GamePanel());


        //把setVisible放在add panel后,否则可能出问题
        frame.setVisible(true);

    }
}
