## FIle、IO流概述

FIle：代表文本   IO流：读写数据

### FIle

是java.io.包下的类，File类的对象，代表当前操作系统的文件（可以是**文件**，也可以是**文件夹**）。

- 获取文件信息（大小，文件名，修改时间）
- 判断文件类型
- 创建文件/文件夹
-  删除文件/文件夹

**注意**：File类只能对文件本身进行操作，**不能读写文件里面存储的数据**。

### IO流

用来读写数据的（可以**读写文件**，也可以**读写网络中的数据**...）

---

## File 类 -- 创建

- public File(String pathname)：根据文件路径创建文件对象
- public File(String parent, String child)：根据父路径和子路径名字创建文件对象
- public File(Fileparent,String child)：根据父路径对应文件对象和子路径名字创建文件对象

File可以指向不存在的路径，方便后续create

相对路径是默认从工程下寻找

File可以是文件，也可以是文件夹

-----

## File类 -- 常用方法

**判断文件类型、获取文件信息**：

- public boolean exists()：判断当前文件对象，对应的文件路径是否存在，存在返回true
- public boolean isFile()：判断当前文件对象指代的是否是文件，是文件返回true，反之。
- public boolean isDirectory()：判断当前文件对象指代的是否是文件夹，是文件夹返回true，反之。
- public String getName()：获取文件的名称(包含后缀）
- public long length()：获取文件的大小，返回字节个数
- public long lastModified()：获取文件的最后修改时间。
- public String getPath()：获取创建文件对象时，使用的路
- public String getAbsolutePath()：获取绝对路径

**创建文件、删除文件**：

- public boolean createNewFile()：创建一个新文件（文件内容为空），创建成功返回true，反之。
- public boolean mkdir()：用于创建文件夹，注意：只能创建一级文件夹。
- public boolean mkdirs()：用于创建文件夹，注意：可以创建多级文件夹。
- public boolean delete()：删除文件，或者空文件，注意：**不能删除非空文件夹**，删除后的文件不会进入回收站。

**遍历文件夹**：

- public String[] list()：获取当前目录下所有的"一级文件名称"到一个字符串数组中去返回。
- public File[] listFiles()：获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回 (重点)

**注意事项**：

1. 当主调是文件，或者路径不存在时，返回null
2. 当主调是空文件夹时，返回一个长度为0的数组
3. **当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回**
4. 当主调是一个文件夹，且里面有隐藏文件时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
5. 当主调是一个文件夹，但是没有权限访问该文件夹时，返回null

-----

## 前置知识：递归

- 直接递归：自己调自己。
- 间接递归：调用别人，别人再调用自己。

无退出机制的话会出现 StackOverFlowError（占内存溢出）。

**递归算法三要素**：

1. 递归的公式
2. 递归的终结点
3. 递归的方向必须走向终结点

**寻找文件demo**：

~~~java
public static void main(String[] args) {
    searchFile(new File("E:\\notes\\狂神说java\\java常用类、集合、IO"), "javaIO流.md");
}

public static void searchFile(File dir, String fileName) {
    // 1.将非法dir拦截
    if (dir == null || fileName == null || !dir.exists() || dir.isFile()) {return;}

    // 2.dir肯定是路径
    // 获取一级目录
    File[] files = dir.listFiles();

    // 3.判断以及一级文件目录不是null，并且不为空
    if (files != null && files.length > 0) {
        // 4.遍历一级文件目录
        for (File f : files) {
            // 5.如果是文件，则判断是否是目标文件
            if (f.isFile() && f.getName().equals(fileName)) {
                System.out.println(f.getAbsolutePath());
                return;
            } else {
                // 6.如果是文件则递归
                searchFile(f, fileName);
            }
        }
    }
}
~~~

-----

## 前置知识：字符集

**标准ASCII字符集**：

- 美国信息交换标准代码，包含英文、符号等。
- 标准ASCII使用了**1个字节存储一个字符**，**首位是0**，总共可表示**128个字符**。

**GBK**：汉字内码扩展规范，国标

- 汉字编码字符集，包含2万多个汉字等字符
- **一个中文字符编码成两个字节**的形式存储，**第一个字节的第一位是1**
- GBK兼容了ASCII字符集

**Unicode字符集**：统一码，万国码

国际组织制定，可以容纳世界上所有文字、符号的字符集。

1. **UTF-32**：**4个字节**...**占存储空间，通行效率变低**，不被大家所接纳

2. **UTF-8**：可变长编码方案，共分四个长度区：1个字节，2个字节，3个字节，4个字节。

   - **兼容标准ASCII编码，汉字字符占3个字节。**

   | UTF-8编码方法（二进制）                   |
   | ----------------------------------------- |
   | 0xxxxxxx   (ASCII码)                      |
   | 110xxxxx   10xxxxxx                       |
   | 1110xxxx   10xxxxxx   10xxxxxx            |
   | 11110xxx   10xxxxxx   10xxxxxx   10xxxxxx |

**要点**：

- **ASCII**字符集：只有**英文、数字、符**号等，**占1个字节**。
- **GBK**字符集：**汉字占2个字节**，**英文、数字占1个字节**。
- **UTF-8**字符集：**汉字占3个字节**，**英文、数字占1个字节**。

**注意**：

1. **字符编码时使用的字符集，和解码时使用的字符集必须一致**，否则会出现乱码
2. **英文，数字一般不会乱码**，因为很多字符集都兼容了ASCII编码。

------

## 编码与解码

**String提供方法**：

编码：

1. byte[] getBytes()：使用平台的默认字符集将该String编码为一系列字节，将结果存储到新的字节数组中
2. byte[] getBytes(String charsetName)：使用指定的字符集将该String编码为一系列字节，将结果存储到新的字节数组中

解码：

1. String(byte[] bytes)：通过使用平台的默认字符集解码指定的字节数组来构造新的String
2. String(byte[] bytes, String charsetName)：通过指定的字符集解码指定的字节数组来构造新的String

~~~java
String str = "a我m";
// 编码
byte[] bytes1 = str.getBytes(); // utf-8   5字节
System.out.println(Arrays.toString(bytes1));
byte[] bytes2 = str.getBytes("GBK"); // gbk   4字节
System.out.println(Arrays.toString(bytes2));

// 解码
String s1 = new String(bytes1);
System.out.println(s1);

// 编码与解码不一致
String s2 = new String(bytes2);
System.out.println(s2);

String s3 = new String(bytes2, "GBK");
System.out.println(s3);
~~~

----

## IO流

IO流体系

1. 字节流：以字节形式读入写出，适用于所有类型文件
   1. InputStream 抽象类
      - FileInputStream 实现类
   2. OutputStream 抽象类
      - FileOutputStream 实现类
2. 字符流：以字符形式读入写出，只适用于纯文本文件
   1. Reader 抽象类
      - FileReader 实现类
   2. Writer 抽象类
      - FileWriter 实现类

---

## FileInputStream

内存为基准，可以把磁盘文件中的数据以字节的形式读入到内存中去。

- public FileInputStream(File file)：创建字节输入流管道与源文件接通。
- public FileInputStream(String pathname)：创建字节输入流管道与源文件接通。
- public int read()：每次读取一个字节返回，如果发现没有数据可读会返回-1。
- public int read(byte[] buffer)：每次用一个字节数组去读取数据，返回字节数组读取了多少个字节，如果发现没有数据可读会返回-1。

调用完之后，一定要释放资源.close()

**注意**：使用FilelnputStream中read()每次读取一个字节，读取性能较差，并且读取汉字输出会乱码。在read(byte[] buffer)中性能显著提升，根据buffer的长度增长而提高，但是也可能会出现乱码错误。FilelnputStream适合文件的拷贝。

-----

## FileOutputStream

内存为基准，把内存中的数据以字节的形式写出到文件中去。

- public FileOutputStream(File file)：创建字节输出流管道与源文件对象接通
- public FileOutputStream(String filepath)：创建字节输出流管道与源文件路径接通
- public FileOutputStream(File file, boolean append)：创建字节输出流管道与源文件对象接通，可追加数据
- public File0utputStream(String filepath, boolean append)：创建字节输出流管道与源文件路径接通，可追加数据
- public void write(int a)：写一个字节出去
- public void write(byte[] buffer)：写一个字节数组出去
- public void write(byte[] buffer, int pos, int len)：写一个字节数组的一部分出去。
  public void close() throws IOException：关闭流。

**拷贝案例**：

~~~java
InputStream is = new FileInputStream("拷贝文件");
OutputStream os = new FileOutputStream("目的地文件");

byte[] bytes = new byte[1024];
int size = -1;
while ((size = is.read(bytes)) != -1) {
    os.write(bytes, 0, size);
}

// 一般的关流顺序为：后创建先关，先创建后关
os.close();
is.close();
~~~

----

## 释放资源方法

1. **try-catch-finally**：千万不能在finally中加返回数据（return）。

   finally中的代码除了JVM终止，否则都会执行。

   **作用**：一般用于程序执行完成之后的资源释放。

将上面的拷贝案例进行改写：

~~~java
InputStream is = null;
OutputStream os = null;
try {
    is = new FileInputStream("拷贝文件");
    os = new FileOutputStream("目的地文件");

    byte[] bytes = new byte[1024];
    int size = -1;
    while ((size = is.read(bytes)) != -1) {
        os.write(bytes, 0, size);
    }
} catch (IOException e) {
    throw new RuntimeException(e);
} finally {
    // 一般的关流顺序为后创建先关，先创建后关
    try {
        if (os != null) os.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    try {
        if (is != null) is.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

System.out.println("拷贝成功");
~~~

​      太臃肿，不优雅。JDK7 诞生了try-with-resource

2. **try-with-resource**：资源使用完后，**自动调用close()方法**，完成对资源的释放！

   ~~~java
   try (定义资源1; 定义资源2;...) {
       	可能出现异常的代码;
   } catch (异常类名 变量名) {
       	异常的处理代码;
   }
   ~~~

   **注意**：

   - 在try的小括号 () 中，只能防止资源，否则会报错
   - 资源一般是指占用了系统的资源，在底层进行了读写，但是这里解释为**类实现了AutoCloseable接口**。

将上面的copy案例进行改写：

~~~java
try (InputStream is = new FileInputStream("base\\src\\com\\base\\io\\test.txt");
        OutputStream os = new FileOutputStream("base/src/com/base/io/testOut.txt")) {
    byte[] bytes = new byte[1024];
    int size = -1;
    while ((size = is.read(bytes)) != -1) {
        os.write(bytes, 0, size);
    }
} catch (Exception e) {
    throw new RuntimeException(e);
}

System.out.println("拷贝成功");
~~~

   

















