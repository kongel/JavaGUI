# Java  gui图形界面

AWT(Abstract Window Toolkit)：抽象窗口工具包，早期编写[图形界面](https://so.csdn.net/so/search?q=图形界面&spm=1001.2101.3001.7020)应用程序的包。
Swing：为解决 AWT 存在的问题而新开发的图形界面包。Swing是对AWT的改良和扩展。

swing常用组件

文本框（JTextField）

密码框（JPasswordField）

标签（JLable）

复选框组件（JCheckBox）

下拉框（JComboBox）

[JFrame](https://so.csdn.net/so/search?q=JFrame&spm=1001.2101.3001.7020)是一个顶层的框架类，好比一个窗户的框子。也是一个容器类。这个框子可以嵌入几个玻璃窗。

JPanel是一个容器类，相当于一大玻璃窗。

JCheckBox是Swing中的复选框。所谓复选框就是指，可以同时存在多个这样的控件，它们可以有多个处于被选中状态。对于每一个复选框而言，它只有选中和未选中两种状态。

Java布局

1、java.awt **FlowLayout（流布局）**将组件按从左到右而后从上到下的顺序依次排列，一行不能放完则折到下一行继续放置。流式布局可以以左对齐、居中对齐、右对齐的方式排列组件。流式布局不限制他所管理的组件的大小，允许他们有最佳的大小。当容器最缩放时，组件的位置可以改变，但组件的大小不改变。**JPanel的默认布局为流式布局管理。**

2、java.awt **BorderLayout（边界布局）**将组件按东、南、西、北、中五个区域放置，每个方向最多只能放置一个组件。**JFrame窗体，JDialog对话框组件默认布局方法为边界布局（BorderLayout）**，边界布局的五个部分不是都要添加，中间部分会自动调节大小。



4、一个界面只可以有一个JFrame窗体组件，但可以有多个Jpanel面板组件，而JPanel上也可使用各种布局管理器，这样可以组合使用达到较为复杂的布局效果。
  JPanel是JComponent的子类。默认布局为流式布局（FlowLayout），属于容器类组件，可以加入别的组件。





缺点:

老,过时

界面不美观

需要jre



优点:

了解监听机制

## awt库

abstract widow tools

components组件

两种component

直接使用的

容器container(很多组件放在容器中)

![image-20220505125428499](C:\Users\yangye\AppData\Roaming\Typora\typora-user-images\image-20220505125428499.png)



### frame

```
    //Gui 的第一个界面
    public static void main(String[] args){
        //Frame,JDK,看源码！（JDK帮助文档）
        Frame frame = new Frame("我的第一个Java图像界面窗口");
        //需要设置可见性
        frame.setVisible(true);
        //设置窗口大小
        frame.setSize(400,400);
        //设置背景颜色，可以直接查源代码设置已有的颜色frame.setBackground(Color.black);
        //也可以直接输入new color(r.g.b)三基色
        frame.setBackground(new Color(37, 80, 167));
        //弹出的初始位置
        frame.setLocation(200,200);
        //已经大概有雏形，但是没有设置关闭窗口功能，最小化、最大化、窗口尺寸已经默认存在。
        //设置大小固定
        frame.setResizable(false);
    }







import java.awt.*;
public class TestFrame2 {
    public static void main(String[] args) {
        //可能需要多个窗口
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200, Color.blue);
        MyFrame myFrame2 = new MyFrame(150, 150, 200, 200, Color.yellow);
        MyFrame myFrame3 = new MyFrame(200, 200, 200, 200, Color.red);
        MyFrame myFrame4 = new MyFrame(250, 250, 200, 200, Color.green);
    }
}
class MyFrame extends Frame {
    static int id = 0;      //可能存在多个窗口，需要一个计数器
    public MyFrame(int x,int y,int w,int h,Color color){
        super("Myframe+"+(++id));//继承
        setBounds(x, y, w, h);//坐标
        setBackground(color);//颜色
        setVisible(true);//可见性
    }
}

```

### pannel

面板在容器里面,不能单独存在

```
import java.awt.*;
//panel 可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args){
        Frame frame = new Frame();  //new 窗口
        //布局的概念
        Panel panel = new Panel();  //new 面板
        Panel panel1 = new Panel();
        //设置布局,不设置面板会置顶
        frame.setLayout(null);
        //窗口坐标和颜色
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(140, 208, 212));
        //panel 设置坐标，相对于frame
        panel.setBounds(50,50,400,100);
        panel.setBackground(new Color(181, 186, 54));
        panel1.setBounds(50,200,400,250);
        panel1.setBackground(new Color(165, 34, 101));
        //将panel添加进frame
        frame.add(panel1);
        frame.add(panel);
        frame.setVisible(true);

    }
}

```



### 窗口关闭功能

```
//监听事件，监听窗口关闭事件 System.exit(0)强制结束
/*frame.addWindowListener(new WindowListener() {
    @Override
    public void windowOpened(WindowEvent e) {

    }
    @Override
    public void windowClosing(WindowEvent e) {

    }
});......
直接new WindowListener()子类太多，接口new出来
可以使用适配器模式，new 其中一项需要的子类*/
frame.addWindowListener(new WindowAdapter() {
    //窗口点击关闭的时候需要的事情
    @Override
    public void windowClosing(WindowEvent e) {
        //结束程序
        System.exit(0);
    }

```

### 布局管理器

流式布局

frame.setLayout(new FlowLayout(0));

东西南北中布局

frame.add(按键名字,BorderLayout.EAST方位);

表格布局

TestGridLayout



### 作业

构思:80%时间

代码:20%时间

![image-20220507154707030](C:\Users\yangye\AppData\Roaming\Typora\typora-user-images\image-20220507154707030.png)



![image-20220507160432749](C:\Users\yangye\AppData\Roaming\Typora\typora-user-images\image-20220507160432749.png)

```
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

```



1.frame是一个顶级窗口

2.panel无法单独显示,放在frame中

3布局管理器

flow

border

grid

4大小,定位,颜色,可见性,监听



### 事件监听

frame.pack()这个函数的作用就是根据窗口里面的布局及组件的preferredSize来确定frame的最佳大小

```
button.addActionListener(this);自己这个类就实现了actionlisten接口,重写了方法,调用的就是本类重写的



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestActionTwo {
    public static void main(String[] args) {
        //两个按钮，实现同一个监听
        //开始--停止
        Frame frame = new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");
        
        //设置e.getActionCommand得到的值
      // button2.setActionCommand("button2-stop");
        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);
        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
class MyMonitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        /*e.getActionCommand() 获取按钮的信息
        System.out.println("按钮被点击了：msg=>"+e.getActionCommand());
        输出结果butoo2为"按钮被点击了：msg=>stop";可以显示的定义触发会返回的命令
        butoo1为"start"。无显示定义，则会走默认的值。
        */
        //可以多个按钮只写一个监听类
        if (e.getActionCommand().equals("start")){//equals 等号
            System.out.println(e.getActionCommand()+"按钮被点击");
        } if (e.getActionCommand().equals("stop")){
            System.out.println(e.getActionCommand()+"按钮被点击");
        }
    }
}

```

### 5输入框TextField

TextArea输入多行文本

TextField输入单行文本



```
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        new MyFrame();
    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();//文本 TextArea文本域，可以写多行
        
        //直接子类调用父类的成员方法,不需要实例化
        //this.add(textField);
        add(textField);
        //监听这个文本框输入的文字
        MyActionListener2 myActionListener2 = new MyActionListener2();
        //按下enter 就会触发这个输入框的事件
        textField.addActionListener(myActionListener2);
        //设置替换编码,保证安全性,
        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}
class MyActionListener2 implements ActionListener{//监听器
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField field = (TextField)e.getSource();//获得一些资源,返回的一个对象
        System.out.println(field.getText());//获得输入框的文本
        field.setText("");//设置enter 后的状态,这里是自动清空
    }
}

```

### 6简易计算器,组合+内部类

oop原则：组合大于继承！

```
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TesCalc {
    public static void main(String[] args) {
        new Calculator();
    }
}
class Calculator extends Frame{     //计算器类
    public Calculator() {
        //3个文本框
        TextField num1 = new TextField(10);//字符数，框的大小,最多能填几位数
        TextField num2 = new TextField(10);
        TextField num3 = new TextField(20);
        //1个按钮
        Button button = new Button("=");
        //按钮的监听事件
        button.addActionListener(new MyCalculatorListener(num1,num2,num3));
        //1个标签,什么都没有
        Label label = new Label("+");
        //布局
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);
        pack();
        setVisible(true);
    }
}
class MyCalculatorListener implements ActionListener{       //监听器类
    //获取三个变量
    private TextField num1,num2,num3;
    public MyCalculatorListener(TextField num1,TextField num2,TextField num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //1.获取加数和被加数
        int n1 = Integer.parseInt(num1.getText());      //将String类转换为int类
        int n2 = Integer.parseInt(num2.getText());
        //2.将这个值+法运算后，放到第三个框
        num3.setText(""+(n1+n2));      //String类+int类，后面的int类会转换为String类
        //3.清楚前两个框
        num1.setText("");
        num2.setText("");
    }
}

```

### 7画笔

```
import java.awt.*;
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}
class MyPaint extends Frame {
    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);//paint方法在setvisible方法中自动调用
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

```



### 8鼠标监听

![image-20220508141521653](C:\Users\yangye\AppData\Roaming\Typora\typora-user-images\image-20220508141521653.png)

```
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

//鼠标监听事件
public class TestMouseListener {	//（1）
    public static void main(String[] args) {
    new MyFrame("画图");
    }
}
//自己的类
class MyFrame extends Frame{		//（2）
    //画画需要画笔，需要监听鼠标当前的位置，需要集合来存储这个点
    ArrayList points;


    public MyFrame(String title) {//--------框架
        super(title);       //名字                                           
        setBounds(200, 200, 400, 300);
        //存标点击的点
        points = new ArrayList<>();
        //鼠标监听器，针对这个窗口
        this.addMouseListener(new MyMouseListener());        //-监听鼠标

        setVisible(true);
    }
    @Override				//（3）
    public void paint(Graphics g) { //画画                  //--------------画笔存储实施
        //画画，需要监听鼠标的事件
        Iterator iterator = points.iterator();              //-迭代器
        while (iterator.hasNext()){                         //检查序列中是否还有元素
            Point point = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(point.x,point.y,10,10);
        }
    }
    //添加一个点到界面上，点集合			//（4）
    public void addPaint(Point point){
        points.add(point);                  //将（点）传到迭代器里


    }


    //适配器模式，就是别人已经写好的端口，不用全部重写内部类，直接继承更加方便。
    private class MyMouseListener extends MouseAdapter{  //（5）    //----------监听器
            //鼠标，按下，弹起，按下不放。
            @Override
            public void mousePressed(MouseEvent e) {        //-鼠标按下
               MyFrame frame = (MyFrame) e.getSource();     //-鼠标按下的来源
                //这里我点击的时候，就会在界面上产生一个点
                //这个点就是鼠标的点
                frame.addPaint(new Point(e.getX(),e.getY()));//--将监控的（点的坐标）传到点集合
                //每次点击鼠标都需要重写画一遍
                frame.repaint();                             //再次刷漆
            }
        }
}            

```



### 9窗口监听

主要就是关闭窗口和激活窗口两个操作

```
package com.ssxxz.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame("窗口监听");
    }
}
class WindowFrame extends Frame{
    public WindowFrame(String kk) {
        super(kk);
        setBackground(Color.cyan);
        setBounds(100,100,200,200);
        setVisible(true);
        //匿名内部类
        this.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        System.out.println("窗口打开");
                    }
                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.out.println("窗口关闭中");
                    }
                    @Override
                    public void windowActivated(WindowEvent e) {
                        System.out.println("窗口激活");
                        WindowFrame source = (WindowFrame) e.getSource();       //获取框架信息
                        source.setTitle("被激活了");
                    }
                    @Override
                    public void windowStateChanged(WindowEvent e) {
                        WindowFrame source = (WindowFrame) e.getSource();
                        source.setTitle("状态改变了");
                        System.out.println("窗口状态改变");
                    }
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("窗口关闭");
                        System.exit(0);
                    }
                }
        );
    }
   /* 通过匿名内部类可以不用另外创建类
   class MyWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);      //隐藏窗口，通过按钮点击事件
            System.exit(0);         //0正常退出，1非正常退出
        }
    }*/
}

```



### 10键盘监听

```
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//键盘
public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}
class KeyFrame extends Frame{
    public KeyFrame() {
        setBounds(10,10,300,400);
        setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                //获得当前键盘的码
                int keyCode = e.getKeyCode();       //不需要去记录这个数值，直接使用静态属性VK_XXX
                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_UP){     //KeyEvent.VK 按键类
                    System.out.println("你按下了上键！");
                }
                //根据按下不同操作，产生不同结果。
            }
        });
    }
}


```

## swing库

### 1窗口.面板

```
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
        Container contentPane = jf.getContentPane();
        contentPane.setBackground(Color.cyan);
        //关闭事件
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}

```

- Container的子类称为Container。 例如，JPanel，JFrame和JWindow。
- Container只能向自身添加一个Component。
- 每个容器中都存在一个默认布局，可以使用**setLayout**方法覆盖它。
- 也就是说JFrame上是不能直接设布局、添加组件的，它上面其实是有一个面板，添加的组件是加到那个面板上。但后来的JDK简化了这一写法，你直接给JFrame添加组件，它会自动将这个动作转发给那个面板。但需要注意的是，有些操作还是必须用下面那种写法的，比如你想给窗口设置背景色，那么直接给JFrame设是没用的，必须先get那个面板再给它设置背景色才有效。

### 2 JDialog弹窗

绝对布局:强行按坐标进行排放,并且窗口大小不可以改变

Container container = this.getContentPane();
        //绝对布局，会相对容器自动定位
        container.setLayout(null);

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//主窗口
public class DialogDemo extends JFrame {
    public DialogDemo() {
        this.setVisible(true);      //可见
        this.setSize(700,500);          //尺寸
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       //关闭事件
        //JFrame 放东西，容器
        Container container = this.getContentPane();
        //绝对布局，会相对容器自动定位
        container.setLayout(null);
        //按钮
        JButton button = new JButton("点击弹出一个对话框");      //创建
        button.setBounds(30,30,200,50);
        //点击这个按钮的时候，弹出一个弹窗
        button.addActionListener(new ActionListener() {           //监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                //监听弹窗
                new MyDialogDemo();
            }
        });
        container.add(button);      //将按钮放进容器中
    }
    public static void main(String[] args) {
        new DialogDemo();
    }
}
        //弹窗的窗口
class MyDialogDemo extends JDialog{
            public MyDialogDemo() {
                this.setVisible(true);
                this.setBounds(100,100,500,500);
           // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    弹窗可以被关掉，不需要额外添加事件,默认就有关闭事件
                Container container = this.getContentPane();
                container.setLayout(null);

                container.add(new Label("秦老师带你学Java"));
            }
        }

```

### 3标签

```
import javax.swing.*;
import java.awt.*;

//图片，需要实现类，Frame 继承
public class IconDemo extends JFrame implements Icon {

    private int width;
    private int height;

    public IconDemo(){}

    public IconDemo(int width,int height){
        this.width = width;
        this.height = height;
    }


    public void init(){     //图标
        IconDemo iconDemo = new IconDemo(15,15);
        //图标放在标签上，也可以放在按钮上!
        //标签，图标，位置
        JLabel label = new JLabel("icontest", iconDemo, SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new IconDemo().init();
    }
    @Override       //图标尺寸
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}

```

图片添加

```
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo()  {
        //获取图片的地址
        JLabel label = new JLabel("ImageIcon");
        //获取当前类路径
        URL url = ImageIconDemo.class.getResource("xxx.jpg");//获取当前类以下的东西

        ImageIcon imageIcon = new ImageIcon(url);//命名不要冲突
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

```



### 4面板

JPanel

```
import javax.swing.*;
import java.awt.*;


public class JPanelDemo extends JFrame {
    public JPanelDemo() {
        Container container = this.getContentPane();
        //后面参数的意思，面板与面板的间距
        container.setLayout(new GridLayout(2,1,10,10));

        JPanel panel1 = new JPanel(new GridLayout(1, 3));   //GridLayout网格布局
        JPanel panel2 = new JPanel(new GridLayout(2, 1));
        JPanel panel3 = new JPanel(new GridLayout(2, 3));

        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("2"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));

        container.add(panel1);
        container.add(panel2);
        container.add(panel3);

        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new JPanelDemo();
    }
}

```

JScroll滚动条,卷轴

```
import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo() {
        Container container = this.getContentPane();
        //文本域
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText("欢迎学习狂神说Java");
        //Scroll 面板
        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        this.setBounds(100,100,300,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}

```



### 5按钮

图片按钮

```
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {
    public JButtonDemo01() {
        Container container = this.getContentPane();
        //将一个图片变为图标
        URL resource = JButtonDemo01.class.getResource("123.jpg");  //图片路径
        ImageIcon icon = new ImageIcon(resource);       //转换为图标

        //把这个图标放到按钮上
        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");      //图片按钮提示
        //add
        container.add(button);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo01();
    }
}

```

单选按钮(单选框)

```
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame{
    public JButtonDemo02() {
        Container container = this.getContentPane();
        //将一个图片变为图标
        URL resource = JButtonDemo01.class.getResource("123.jpg");  //图片路径
        ImageIcon icon = new ImageIcon(resource);       //转换为图标

        //单选框
        JRadioButton radioButton1 = new JRadioButton("JRadioButton01");
        JRadioButton radioButton2 = new JRadioButton("JRadioButton02");
        JRadioButton radioButton3 = new JRadioButton("JRadioButton03");
        //由于单选框只能选择一个，可以将他们分组，一个组只能选一个。
        ButtonGroup group = new ButtonGroup();      //组
        group.add(radioButton1);                    
        group.add(radioButton2);
        group.add(radioButton3);

        container.add(radioButton1,BorderLayout.CENTER);
        container.add(radioButton2,BorderLayout.NORTH);
        container.add(radioButton3,BorderLayout.SOUTH);


        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}

```

复选按钮(复选框)

```
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo03 extends JFrame {
    public JButtonDemo03() {
        Container container = this.getContentPane();
        //将一个图片变为图标
        URL resource = JButtonDemo01.class.getResource("123.jpg");  //图片路径
        ImageIcon icon = new ImageIcon(resource);       //转换为图标

        //多选框
        JCheckBox checkBox01 = new JCheckBox("checkBox01");
        JCheckBox checkBox02 = new JCheckBox("checkBox02");
        
        container.add(checkBox01,BorderLayout.NORTH);
        container.add(checkBox02,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new JButtonDemo03();
    }
}

```



### 6列表,下拉框

下拉框

```
import javax.swing.*;
import java.awt.*;

public class TsetComboboxDemo01 extends JFrame {
    public TsetComboboxDemo01() {
        Container container = this.getContentPane();
        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("正在上映");
        status.addItem("已下架");
        status.addItem("即将上映");

        // status.addActionListener(); 监听获取值

        container.add(status);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TsetComboboxDemo01();
    }
}

```

列表框

```
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TsetComboboxDemo02 extends JFrame {
    public TsetComboboxDemo02() {
        Container container = this.getContentPane();
        //生产列表的内容
        //String[] contents = {"1","2","3"};    静态数组

        Vector contents = new Vector();

        //列表中需要放入内容
        JList jList = new JList(contents);      //列表

        //动态数组
        contents.add("zhangsan");
        contents.add("lisi");
        contents.add("wangwu");
        
        container.add(jList);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TsetComboboxDemo02();
    }
}

```



- 应用场景
  - 下拉框：选择地址或者一些单个选项（一到两个最好使用按钮，两个以上使用下拉框，节省内存布局）
  - 列表框：展示信息，一般是动态扩容。

### 7文本框

文本框

```
import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame  {
    public TestTextDemo01() throws HeadlessException {
        Container container = this.getContentPane();


        JTextField textField1 = new JTextField("hello",50);    //文本框+尺寸
        JTextField textField2 = new JTextField("world");

        container.add(textField1,BorderLayout.NORTH);
        container.add(textField2,BorderLayout.SOUTH);


        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}

```

密码框

```
import javax.swing.*;
import java.awt.*;

public class TestTextDemo02 extends JFrame {
    public TestTextDemo02() throws HeadlessException {
        Container container = this.getContentPane();

        JPasswordField passwordField = new JPasswordField();    //密码框***
        passwordField.setEchoChar('?');                         //密码框显示符号

        container.add(passwordField);


        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}

```

文本域

```
import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo() {
        Container container = this.getContentPane();
        //文本域
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText("欢迎学习狂神说Java");
        //Scroll 面板
        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);


        this.setBounds(100,100,300,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}

```

## 贪吃蛇

帧率:每秒刷新一次界面,实现动起来,如果时间片足够小，就是动画，一秒30帧以上就已经达到动画效果，拆开就是静态的图片。

键盘监听

定时器Timer





1定义数据

2画上去

3监听事件

键盘

时间







## GUI总结

![image-20220509154109845](C:\Users\yangye\AppData\Roaming\Typora\typora-user-images\image-20220509154109845.png)



常用代码

```
Frame;											框架
Panel;											面板
setVisible;									    可见性true
setSize(x,x);									初始尺寸
setLocation(x,x);								初始位置，x,y
setBounds(x,x,x,x);								初始坐标+尺寸
setBackground（new color(x,x,x)）;   		    颜色，三基色
setResizable;								    大小是否可调，true,false
setLayout(new FlowLayout(FlowLayout.LEFT));		流式布局
frame.add(east,BorderLayout.EAST);				方向布局
frame.setLayout(new GridLayout(3,2));			表格布局
ActionListener;									监听器
TextField;										文本框
TextArea;										文本域
PasswordField;									密码框
Integer.parseInt();								String类转int类
paint;											画笔
MouseAdapter;									鼠标监听器
WindowListener;									窗口监听
KeyListener;									键盘监听
DefaultCloseOperation(WindowConstants.);		关闭事件(JFrame)
ContentPane;									容器(JFrame)
Layout;											容器自动定位(JFrame)
Button;											按钮
RadioButton;									单选按钮
ButtonGroup;									组
CheckBox;										多选按钮
ComboBox;										下拉框
List;											列表框
Dialog;											对话框
Label;											标签
IconDemo;										图标
ImageIcon;										图片
Scroll;											滚动条
Timer;											定时器

```





