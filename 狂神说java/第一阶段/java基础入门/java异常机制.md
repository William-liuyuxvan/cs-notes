## 异常 -----> Exception

#### **区分于Error（JVM错误）**

- 由java虚拟机生成并抛出，大多数错误与代码编写这所执行的操作无关。
- 无法预料
- **灾难性的致命性的异常**
- 程序无法处理的

#### Exception

- 可预测的。
- 在其中有一个非常重要的子类RuntimeException（运行时异常），因此可以将Exception分为 **运行时异常** **和非运行时异常**。
- RuntimeException中有以下几类：
  - ArraylndexOutOfBoundsException（数组下标越界）
  - NullPointerException（空指针异常）
  - ArithmeticException（算术异常）
  - MissingResourceException（丢失资源）
  - ClassNotFoundException（找不到类）
  - 等等异常
- 可被处理的

----

## 捕获和抛出异常

- 在 try/catch 中，finally可以省略，但是**在io中需要资源关闭的时候 finally 必须添加**，既是不管有没有异常都要执行的语句。
- throw 和 throws 是两个关键词，throw是主动抛出异常，throws应用在方法上向上抛出。
- 少数用 printStackTrace() 去打印输出

-----

## 自定义异常类

继承 Exception 父类

重新 toString()

传递 detail 值