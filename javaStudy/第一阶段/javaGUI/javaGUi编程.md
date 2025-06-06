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

- 流式布局 -- FlowLayout

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

  

- 东西南北中 -- BorderLayou

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

  

- 表格布局 -- GridLayout

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



#### 4. 事件监听 -- implements ActionListener

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



#### 5. 输入框 -- TextField

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



#### 6. 画笔 -- paint(Graphics g)

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



#### 7. 鼠标监听 -- extends MouseAdapter

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



#### 9. 键盘监听 -- addKeyListener(new KeyAdapter()

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



## 2.Swing -- 对AWT的再封装升级

#### 1. 弹窗 -- extends JDialog

默认有隐藏窗口，不要输入WindowConstants.EXIT_ON_CLOSE

```java
class MyDialog extends JDialog {
    public MyDialog() {
        setBounds(100, 100, 450, 300);
        setVisible(true);

        Container container = getContentPane();
        container.setLayout(new GridLayout(1,1));
        container.add(new Label("asdfasfasdf af asf "));
    }
}
```



#### 2. 标签

##### 2.1 标签 -- label

~~~java
new JLabel("xxx");
~~~



##### 2.2 图标 --  icon

```java
public class TestIcon extends JFrame implements Icon {

    private int width;
    private int height;

    public TestIcon() {}

    public TestIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        TestIcon icon = new TestIcon(15, 15);
        Container contentPane = getContentPane();
        contentPane.add(new JLabel("icon", icon, SwingConstants.CENTER));

        setBounds(100, 100, 600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestIcon().init();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.getWidth();
    }

    @Override
    public int getIconHeight() {
        return this.getHeight();
    }
}
```



##### 2.3 图片 -- ImageIcon

在TestImageIcon.class.getResource("lyx.jpeg");的时候可能是因为target目录下没有相应的文件，找不到。

```java
public class TestImageIcon extends JFrame {
    public static void main(String[] args) {
        new TestImageIcon().init();
    }

    private void init() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel jLabel = new JLabel("a ");
        URL url = TestImageIcon.class.getResource("lyx.jpeg");

        ImageIcon imageIcon = new ImageIcon(url);

        jLabel.setIcon(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(jLabel);
    }
}
```



##### 2.4 面板 -- JPanel

```java
public class TestJPanel extends JFrame {

    public TestJPanel() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2, 10,10));
        JPanel jPanel1 = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(2, 1, 1,1));

        jPanel1.add(new JButton("1"));
        jPanel1.add(new JButton("1"));
        jPanel2.add(new JButton("2"));
        jPanel2.add(new JButton("2"));

        container.add(jPanel1);
        container.add(jPanel2);

    }

    public static void main(String[] args) {
        new TestJPanel();
    }
}
```



##### 2.5 滚动面板 -- JScrollPane

```java
public class TestJScrollPanel extends JFrame {

    public TestJScrollPanel() {
        // 基本设置
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // 添加文本域到滚动面板中
        JScrollPane scrollPane = new JScrollPane(new JTextArea("欢迎来到这大千世界！", 10,20));

        // 将面板添加到容器中
        getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        new TestJScrollPanel();
    }
}
```



##### 2.6 图片按钮 -- new JButton(icon)

```java
public class TestIconButton extends JFrame {

    public TestIconButton() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        URL url = TestIconButton.class.getResource("image.jpg");
        ImageIcon icon = new ImageIcon(url);

        JButton button = new JButton(icon);
        button.setToolTipText("imageicon");

        getContentPane().add(button);
    }

    public static void main(String[] args) {
        new TestIconButton();
    }
}
```



##### 2.7 单选框 -- JRadioButton

在单选框中只允许选择一个，因此需要用到 ButtonGroup 进行分成一个组，但是添加按钮的话也是用container进行添加button，而不是buttongroup。

```java
public class TestJRadioButton extends JFrame {

    public TestJRadioButton() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JRadioButton button1 = new JRadioButton("btn1");
        JRadioButton button2 = new JRadioButton("btn2");
        JRadioButton button3 = new JRadioButton("btn3");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);

        getContentPane().add(button1, BorderLayout.NORTH);
        getContentPane().add(button2, BorderLayout.CENTER);
        getContentPane().add(button3, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TestJRadioButton();
    }
}
```



##### 2.8多选框 -- JCheckBox

```java
public class TestJCheckBox extends JFrame {

    public TestJCheckBox() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JCheckBox checkBox1 = new JCheckBox("多选1");
        JCheckBox checkBox2 = new JCheckBox("多选2");
        JCheckBox checkBox3 = new JCheckBox("多选3");

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(checkBox1);
        getContentPane().add(checkBox2);
        getContentPane().add(checkBox3);
    }

    public static void main(String[] args) {
        new TestJCheckBox();
    }
}
```



##### 2.9 下拉框 -- JComboBox<>()

```java
public class TestJComboBox extends JFrame {

    public TestJComboBox() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Container container = getContentPane();

        JComboBox status = new JComboBox();

        status.addItem("选项1");
        status.addItem("选项2");
        status.addItem("选项3");
        status.addItem("选项4");

        container.add(status);
    }

    public static void main(String[] args) {
        new TestJComboBox();
    }
}
```



##### 2.10 列表框 -- JList

静态添加删除内容 String[]：

```java
public class TestJList extends JFrame {

    public TestJList() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Container container = getContentPane();

        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        JList list = new JList(str);
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        container.add(scrollPane);
    }

    public static void main(String[] args) {
        new TestJList();
    }
}
```

动态添加删除内容 Vector：

```java
public class TestJList extends JFrame {

    public TestJList() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Container container = getContentPane();

        Vector vector = new Vector();
        JList list = new JList(vector);
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        container.add(scrollPane);

        vector.add("1");
        vector.add("1");
        vector.add("1");
    }

    public static void main(String[] args) {
        new TestJList();
    }
}
```

- **应用场景**：

  - 选择地区，或者一些单个选项 -> 下拉框（节省内存获取）

  - 列表，展示信息，一般是动态扩容 -> 列表框



##### 2.11 密码框 -- JPasswordField

除了利用JTextField中的方法setEchoChar('*')外，还有一个类是**JPasswordField**，默认显示为 · ，也可以利用setEchoChar()来设置其他的显示方式。

```java
public class TestJPasswordField extends JFrame {

    public TestJPasswordField() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPasswordField passwordField = new JPasswordField(20);

        getContentPane().add(passwordField);
    }
    
    public static void main(String[] args) {
        new TestJPasswordField();
    }
}
```



##### 2.12 文本域 -- JTextArea    new JTextArea(20, 50)



## 贪吃蛇Demo

见 `狂神说java\project\base\src\com\base\gui\snakeDemo`













