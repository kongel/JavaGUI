package com.kuang.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏的面板
//直接实现监听接口
//KeyListener键盘监听器
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    //定义蛇的属性
    int length;
    int[] snakeX=new int[600];
    int[] snakeY=new int[600];
    String direction;
    //游戏当前的状态
    boolean isStart;

    //食物的坐标
    int foodx;
    int foody;
    Random random=new Random();
    //监听器
    Timer timer=new Timer(100,this);//100ms刷新一次

    boolean isFail;

    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    public void init(){
        length=3;
        direction="R";
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        isStart=false;


        foodx=25+25*random.nextInt(34);
        foody=25+25*random.nextInt(24);

        isFail=false;
    }

    //绘制面板,游戏中的东西,采用这个面板画
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏,不清屏,会闪烁
        this.setBackground(Color.WHITE);

        Data.head.paintIcon(this,g,25,11);//头部广告栏画上去
        g.fillRect(25,75,850,600);//画黑色矩形

        if(direction.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for (int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if(isStart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }
        Data.food.paintIcon(this,g,foodx,foody);

        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("失败,按空格重新开始",300,300);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,15));
        g.drawString("当前长度:"+length,700,30);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_SPACE){
            if(isFail){
                isFail=false;
                init();
            }else {
                isStart=!isStart;
            }

            repaint();
        }


        if(code==KeyEvent.VK_UP){
            direction="U";
        }else if(code==KeyEvent.VK_DOWN){
            direction="D";
        }else if(code==KeyEvent.VK_LEFT){
            direction="L";
        }else if(code==KeyEvent.VK_RIGHT){
            direction="R";
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //事件监听,固定事件刷新,1秒10次
    //通过定时器来实现
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFail==false){
            if(snakeX[0]==foodx && snakeY[0]==foody){
                length++;
                foodx=25+25*random.nextInt(34);
                foody=25+25*random.nextInt(24);
            }

            for(int i=length-1;i>0;i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            if(direction.equals("R")){
                snakeX[0]+=25;
            }else if(direction.equals("U")){
                //这里向上是减坐标
                snakeY[0]-=25;
            }else if(direction.equals("D")){
                snakeY[0]+=25;
            }else if(direction.equals("L")){
                snakeX[0]-=25;
            }

            //边界判断
            if(snakeX[0]>850){
                snakeX[0]=25;
            }else if(snakeX[0]<25){
                snakeX[0]=850;
            }
            if(snakeY[0]>650){
                //广告栏下方
                snakeY[0]=75;
            }else if(snakeY[0]<75){
                snakeY[0]=650;
            }
        }

        //撞到自己失败
        for(int i=1;i<length;i++){
            if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                isFail=true;
                break;
            }
        }

        repaint();
    }
}
