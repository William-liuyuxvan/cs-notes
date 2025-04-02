## FIle、IO流概述

FIle：代表文本   IO流：读写数据

### FIle

是java.io.包下的类，File类的对象，代表当前操作系统的文件（可以是**文件**，也可以是**文件夹**）。

- 获取文件信息（大小，文件名，修改时间）
- 判断文件类型
- 创建文件/文件夹
- 删除文件/文件夹

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
- 简介递归：调用别人，别人再调用自己。

无退出机制的话会出现 StackOverFlowError（占内存溢出）。





