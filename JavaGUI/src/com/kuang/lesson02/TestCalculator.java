package com.kuang.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCalculator {
}
class Calculator{
    public static void main(String[] args) {
        TextField t1=new TextField(10);
        TextField t2=new TextField(10);

        TextField t3 = new TextField();
        Label l=new Label("+");
        Button b=new Button("=");
        Frame frame=new Frame();
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setLayout(new FlowLayout());
        Mylistener m=new Mylistener(t1,t2,t3);
        b.addActionListener(m);

        frame.add(t1);
        frame.add(l);
        frame.add(t2);
        frame.add(b);
        frame.add(t3);
    }
}
class Mylistener implements ActionListener{
    TextField t1;
    TextField t2;
    TextField t3;

    public Mylistener() {
    }

    public Mylistener(TextField t1, TextField t2, TextField t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = t1.getText();
        int a=Integer.parseInt(s1);
        int b=Integer.parseInt(t2.getText());

        t3.setText(a+b+"");
    }
}
