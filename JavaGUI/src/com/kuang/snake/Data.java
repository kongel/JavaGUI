package com.kuang.snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    //重启idea
    //public static URL url=Data.class.getResource("");
    public static URL headUrl=Data.class.getResource("static/header.png");
    public static URL bodyUrl=Data.class.getResource("static/body.png");
    public static URL foodUrl=Data.class.getResource("static/food.png");

    public static URL upUrl=Data.class.getResource("static/up.png");
    public static URL downUrl=Data.class.getResource("static/down.png");
    public static URL leftUrl=Data.class.getResource("static/left.png");
    public static URL rightUrl=Data.class.getResource("static/right.png");

    public static ImageIcon head=new ImageIcon(headUrl);
    public static ImageIcon body=new ImageIcon(bodyUrl);
    public static ImageIcon food=new ImageIcon(foodUrl);

    public static ImageIcon up=new ImageIcon(upUrl);
    public static ImageIcon down=new ImageIcon(downUrl);
    public static ImageIcon left=new ImageIcon(leftUrl);
    public static ImageIcon right=new ImageIcon(rightUrl);


    public static void main(String[] args) {
        System.out.println(headUrl);
        //System.out.println(url);
    }


}
