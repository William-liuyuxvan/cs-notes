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



















