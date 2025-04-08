## GUi编程

核心技术：Swing  AWT

1. 界面不美观
2. 需要 jre 环境，环境太大

学习目的：

1. 了解MVC架构，了解监听
2. 写一些自己的小工具

AWT类似于Swing的前身

用AWT做底层实现  Swing做界面

## 1. AWT

### 1.1 Awt介绍

1. 类和接口  GUI
2. 元素：窗口、按钮、文本框
3. java.awt

![image-20250407113248545](C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250407113248545.png)

### 1.2 组件和容器

#### 1. frame

~~~java
// 1.创建对象
Frame frame = new Frame("yuxuan的第一个frame");

// 2.设置可见性
frame.setVisible(true);

// 3.设置初始位置，大小
frame.setBounds(200, 200, 300, 300);

// 4.设置颜色
frame.setBackground(Color.BLUE);

// 5.设置是否可以改变窗口大小
frame.setResizable(false);```
~~~

<img src="C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250407115749133.png" alt="image-20250407115749133" style="zoom:70%;" />



#### 2. Panel

panel是在frame中的，具有流概念，需要在frame中添加，不能单独使用。

```java
// new对象
Frame frame = new Frame("Test Panel");
Panel panel = new Panel();

// 设置布局
frame.setLayout(null);

// 设置坐标
frame.setBounds(200, 200, 300, 300);
frame.setBackground(Color.gray);

// 设置panel坐标，相对于frame
panel.setBounds(50,50,200,200);
panel.setBackground(Color.BLUE);

// panel放入frame中
frame.add(panel);

// 可见性
frame.setVisible(true);
```

<img src="C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250407144310254.png" alt="image-20250407144310254" style="zoom:50%;" />



#### 3. 布局管理器

- 流式布局 -> FlowLayout

  `new FlowLayout(FlowLayout.LEFT);` 

  默认为中间布局，会自动根据窗口大小调整按钮上下排列

  ```java
  Frame frame = new Frame();
  
  frame.setLayout(new FlowLayout(FlowLayout.LEFT));
  
  frame.add(new Button("btn1"));
  frame.add(new Button("btn2"));
  frame.add(new Button("btn3"));
  frame.add(new Button("btn4"));
  
  frame.setVisible(true);
  ```

  

- 东西南北中 -> BorderLayou

  五个方位布局

  `new BorderLayout()`

  ```java
  Frame frame = new Frame();
  
  frame.setLayout(new BorderLayout());
  
  frame.add(new Button("EAST"), BorderLayout.EAST);
  frame.add(new Button("WEST"), BorderLayout.WEST);
  frame.add(new Button("CENTER"), BorderLayout.CENTER);
  frame.add(new Button("SOUTH"), BorderLayout.SOUTH);
  frame.add(new Button("NORTH"), BorderLayout.NORTH);
  
  frame.pack();
  
  frame.setVisible(true);
  ```

  

- 表格布局 -> GridLayout

  `new GridLayout(2,3)`

  ```java
  Frame frame = new Frame();
  
  frame.setLayout(new GridLayout(2,3));
  
  frame.add(new Button("EAST1"));
  frame.add(new Button("WEST2"));
  frame.add(new Button("WEST3"));
  frame.add(new Button("WEST4"));
  frame.add(new Button("WEST5"));
  frame.add(new Button("WEST6"));
  
  frame.pack();
  
  frame.setVisible(true);
  ```



#### 4. 事件监听

​	自写监听器需要继承ActionListener，可以通过e.getActionCommand()获取名字（如果组件运用了setActionCommand()则获取设置的command信息），然后进行精确监听操作。

​	则是可以通过一个监听器，实现多个组件的监听。

~~~java
class MyMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "btn1") {
            // todo...
        } else if (e.getActionCommand() == "btn2") {
            // todo...
        }
        // todo...
    }
}
~~~



#### 5. 输入框TextField

​	输入框，不能换行，但是可以利用actionPerformed进行回车监听，TextArea可以换行。

面向对象写法：

```java
public class TestTextField {
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyFrame extends Frame {
    public MyFrame() {
        TextField textField = new TextField();
        add(textField);

        MyMonitor myMonitor = new MyMonitor();
        textField.addActionListener(myMonitor);

        textField.setEchoChar('*'); // 设置输入展示，密码形式

        addWindowListener(myMonitor);

        pack();
        setVisible(true);
    }
}

class MyMonitor extends WindowAdapter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();
        System.out.println(textField.getText());
        textField.setText(""); // 回车后清空
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
```



简易计算器，整理后，**面向对象写法**：

```java
public class Demo1 {
    public static void main(String[] args) {
        new Calculator();
    }
}

class Calculator extends Frame {
    TextField num1;
    TextField num2;
    TextField num3;

    public void loadFrame() {
        setTitle("Calculator");

        // 三个文本框
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(10);
        // 一个label +
        Label label = new Label("+");
        // 一个按钮 =
        Button button = new Button("=");

        // 流式添加到frame中
        setLayout(new FlowLayout());

        // 布局
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        // 添加监听器
        button.addActionListener(new MyMonitor2(this));

        pack();
        setVisible(true);
    }

    public Calculator() {
        loadFrame();
    }
}

class MyMonitor2 implements ActionListener {

    Calculator calculator;

    public MyMonitor2(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(calculator.num1.getText());
        int n2 = Integer.parseInt(calculator.num2.getText());
        calculator.num3.setText("" + (n1 + n2));
    }
}
```

简易计算器，**内部类**简化代码冗余：

```java
public class Demo1 {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

class Calculator extends Frame {
    TextField num1;
    TextField num2;
    TextField num3;

    public void loadFrame() {
        setTitle("Calculator");

        // 三个文本框
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(10);
        // 一个label +
        Label label = new Label("+");
        // 一个按钮 =
        Button button = new Button("=");

        // 流式添加到frame中
        setLayout(new FlowLayout());

        // 布局
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        // 添加监听器
        button.addActionListener(new MyMonitor2());

        pack();
        setVisible(true);
    }

    public Calculator() {
    }

    private class MyMonitor2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText("" + (n1 + n2));
        }
    }
}
```



#### 6. 画笔paint

```java
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame {
    public void loadFrame() {
        setVisible(true);
        setBounds(200, 200, 600, 500);
        addWindowListener(new MyMonitor());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(50, 50, 40, 100);
    }

    private static class MyMonitor extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
```



#### 7. 鼠标监听

目的：实现鼠标点击画图--画点

思路：

![image-20250408141818095](C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250408141818095.png)

代码实现：

```java
public class TestMouse {
    public static void main(String[] args) {
        new MyMouse("MousePaint").loadFrame();
    }
}

class MyMouse extends Frame {

    private ArrayList list = new ArrayList();

    public MyMouse(String title) {
        super(title);
    }

    public void loadFrame() {
        setBounds(200, 200, 600 ,500);
        setVisible(true);
        addMouseListener(new MyMouseMonitor());
        addWindowListener(new MyMonitor());
    }

    @Override
    public void paint(Graphics g) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Point p = (Point) iterator.next();
            g.fillOval(p.x, p.y, 10, 10);
        }
    }

    // 适配器模式
    private class MyMouseMonitor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            list.add(new Point(e.getX(), e.getY()));
            repaint();
        }
    }

    // 适配器模式
    private static class MyMonitor extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
```

其中的每次点击都可以调用paint()方法是因为在MouseAdapter监听器中监听每次鼠标点击后调用了repaint()方法，会重写调用一次paint()方法，以达到实现目的。

适配器模式：implement需要全部方法重写，因此用适配器模式extends继承一个Adapter进行单独实现功能。



#### 8. 窗口监听

WindowListener是接口，WindowAdapter是实现类，一般继承WindowAdapter进行定点实现方法。

常用方法：

- windowClosing()  正在关闭窗口时调用
- windowActivated()  激活窗口调用



#### 9. 键盘监听

使用 KeyEvent.VK_ 开头的加上需要判断的字符即可

```java
addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (code == KeyEvent.VK_ENTER) {
            System.out.println("ENTER");
        }
    }
});
```









## 2.Swing





















