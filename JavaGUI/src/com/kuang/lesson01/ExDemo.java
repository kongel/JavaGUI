package com.kuang.lesson01;

//课堂作业
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

abstract class Student{
    public void run(){
        System.out.println("run");
    };
    //abstract public void  speak();会报错
    public void  speak(){
        System.out.println("speak");
    }
}
public class ExDemo {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,1));
        frame.setBackground(Color.blue);
        frame.setSize(400,400);
        frame.setLocation(100,100);

        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();

        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(2,1));

        p2.add(new Button("button2"));
        p2.add(new Button("button3"));

        p1.add(new Button("button1"),BorderLayout.EAST);
        p1.add(new Button("button4"), BorderLayout.WEST);
        p1.add(p2,BorderLayout.CENTER);

        p3.setLayout(new BorderLayout());
        p4.setLayout(new GridLayout(2,2));

        p3.add(new Button("5"),BorderLayout.EAST);
        p3.add(new Button("6"),BorderLayout.WEST);
        p3.add(p4,BorderLayout.CENTER);

        for(int i=0;i<4;i++){
            p4.add(new Button("b"+(i+1)));
        }

        frame.add(p1);
        frame.add(p3);

        //通过匿名类的方式实现了,listenner为接口,实现的话需要全部重写
        //windowadapter为抽象类,匿名实现只需要重写抽象方法,随便重写一个也行
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        Student student = new Student() {
            @Override
            public void run() {
                System.out.println("重写的run");
            }

        };
        student.run();
        student.speak();

    }
}
