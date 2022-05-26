package com.kuang.lesson03;

import java.awt.*;
public class TestPaint {
    public static void main(String[] args) {

        new MyPaint().loadFrame();
        //构造方法自动调用paint
    }
}
class MyPaint extends Frame {
    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }
    //画笔，颜色，可以画画
   @Override
    public void paint(Graphics g) {
       // super.paint(g);有些类里面有初始化操作，就无法删除
       g.setColor(Color.red);
       //g.drawOval(100,100,100,100);   //draw空心
       g.fillOval(100,100,100,100);   //fill实心、填充的
       g.setColor(Color.GREEN);
       g.fillRect(200,200,200,200);
       //养成习惯，画笔用完，将它还原到最初的颜色，不然你再化一个图会带上之前的颜色。
    }
}
