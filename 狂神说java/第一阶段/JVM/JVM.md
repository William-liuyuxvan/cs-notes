## JVM 探究体系

### 1. JVM的位置

   <img src="E:\notes\img\jvm1.png" alt="jvm1" style="zoom: 67%;" />

### 2. JVM的体系结构

   <img src="E:\notes\img\jvm2.png" alt="jvm2" style="zoom:67%;" />

   <img src="E:\notes\img\jvm3.png" alt="jvm3" style="zoom:50%;" />

### 3. 类加载器

   - 虚拟机自带的加载器
   - 启动类加载器（根加载器）BootstrapClassLoader
   - 扩展类加载器  ExtClassLoader
   - 应用程序加载器  AppClassLoader

   <img src="C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250414171135639.png" alt="image-20250414171135639" style="zoom:50%;" />

   ~~~bash
   双亲委派机制：
   1. 类加载器收到类加载的请求
   2. 类加载器将这个请求向上委托给父类加载器去完成，直到启动类（根）加载器  bootstrap
   3. 启动类加载器检查是否能加载该类，如果可以加载就结束，使用当前加载器加载该类，否则就抛出异常，通知子类加载器进行加载
   4. 重复步骤 3
   
   不能获取启动类加载器 返回 null ： 由c、C++编写  java调用不到
   java = 在C++中除去繁琐的东西：指针、内存管理。 因此也叫 C++--
   ~~~

   - ==双亲委派机制==：保证系统调用、加载安全

     检查：APP --> EXT -->Boot

     加载：Boot --> EXT --> APP

     类加载器（ClassLoader）在尝试加载类时所遵循的一种特定模式。这个机制的**核心思想**是，当类加载器尝试加载一个类时，它首先会将这个加载任务委托给其父类加载器，这个过程会一直递归进行，直到达到最顶层的启动类加载器（Bootstrap classLoader）。如果父类加载器能够成功加载该类，则直接使用父类加载器的结果。只有当父类加载器无法完成这个加载任务时，才由子类加载器自己去尝试加载。

### 4. 沙箱安全机制

   重要组成部分：**字节码校验器**

   **沙箱机制就是==将Java代码限定在虚拟机(JVM)特定的运行范围中==，==并且严格限制代码对本地系统资源访问==。通过这样的措施来==保证对代码的有限隔离，防止对本地系统造成破坏==。**

   沙箱主要限制系统资源访问，那系统资源包括什么？***\*CPU、内存、文件系统、网络\****。

   ![](E:\notes\img\jvm4.png)

   ![](E:\notes\img\jvm5.png)

   ![](E:\notes\img\jvm6.png)

   ![](E:\notes\img\jvm7.png)

### 5. Native

   带有 native 关键字的说明java的作用范围达不到了，需要进入本地方法库中引用（底层C语言库），调用本地方法接口（JNI），使用本地方法库中的东西。

   在java诞生的时候，C、C++横行，想要立足就必须调用C、C++的程序。于是**专门在内存区域开辟了一块标记区域**：Native Method Area，在最终执行的时候通过JNI调用本地方法库。

   JNI：扩展java的使用，融合不同的编程语言，例如在本地方法库中的C、C++

   一般操作硬件才会用到，一般的网站企业编程并不会用到。

### 6. PC寄存器

   程序计数器：Program Counter Register
   **每个线程都有一个程序计数器**，是**线程私有的**，就**是一个指针**，**指向方法区中的方法字节码（用来存储指向像一条指令的地址，也即将要执行的指令代码）在执行引引擎读取下一条指令**，是一个**非常小的内存空间**，几乎可以忍略不计

### 7. 方法区

   **Method Area 方法区**
   方法区是**被所有线程共享**，所有字段和方法字节码，以及一些特殊方法，如构造函数，接口代码也在此定义，简单说，所有定义的方法的信息都保存在该区域，**此区域属于共享区间**；
   ==静态变量 static、常量 final、类信息 Class (构造方法、接口定义)、运行时的**常量池存在方法区**中，但是**实例变量存在堆内存**
   **中**，和方法区无关==

### 8. 栈 ： 后进先出 先进后出

### 9. 堆

### 10. 年轻代、老年代

![jvm8](E:\notes\img\jvm8.png)

### 11. 永久代 --> jdk1.8开始 元空间（只存储元数据，其他数据都分给堆）

![jvm9](E:\notes\img\jvm9.png)
    
1. 元空间介绍
    在JDK1.7之前，HotSpot 虚拟机把方法区当成永久代（方法区的落地实现）来进行垃圾回收。
    而从 JDK 1.8 开始，移除永久代，并把方法区移至元空间，它位于本地内存中，而不是虚拟机内存中。
    HotSpots取消了永久代，那么是不是也就没有方法区了呢？当然不是，方法区是一个规范，规范没变，它就一直在，只不过取代永久代的是元空间（Metaspace)而已。
    
    ![jvm10](E:\notes\img\jvm10.png)
    
    它和永久代有什么不同的？
    存储位置不同：永久代在物理上是堆的一部分，和新生代、老年代的地址是连续的，而元空间属于本地内存。
    存储内容不同：在原来的永久代划分中，永久代用来存放类的元数据信息、静态变量以及常量池等。现**在类的元信息存储在元空间中，静态变量和常量池等并入堆中，相当于原来的永久代中的数据，被元空间和堆内存给瓜分了。==实例在堆中，但是引用依然在方法区中。==**


2. **为什么要废弃永久代，引入元空间？**
    相比于之前的永久代划分，Oracle为什么要做这样的改进呢？

    在原来的永久代划分中，永久代需要存放类的元数据、静态变量和常量等。它的大小不容易确定，因为这其中有很多影响因素，比如类的总数，常量池的大小和方法数量等，-XX:MaxPermSize **指定太小很容易造成永久代内存溢出**。
    **移除永久代是为融合HotSpot VM与 JRockit VM而做出的努力，因为JRockit没有永久代，不需要配置永久代。**
    **永久代会为GC带来不必要的复杂度，并且回收效率偏低。**

3. **废除永久代的好处**
    由于类的==**元数据分配在本地内存中**==，**元空间的最大可分配空间就是系统可用内存空间。==不会遇到永久代存在时的内存溢出错误。==**
    将运行时常量池从PermGen分离出来，与类的元数据分开，提升类元数据的独立性。
    将元数据从PermGen剥离出来到Metaspace，可以提升对元数据的管理同时提升GC效率。

4. Metaspace相关参数
    -XX:MetaspaceSize，初始空间大小，达到该值就会触发垃圾收集进行类型卸载，同时GC会对该值进行调整：如果释放了大量的空间，就适当降低该值；如果释放了很少的空间，那么在不超过MaxMetaspaceSize时，适当提高该值。
    -XX:MaxMetaspaceSize，最大空间，默认是没有限制的。如果没有使用该参数来设置类的元数据的大小，其最大可利用空间是整个系统内存的可用空间。
    JVM也可以增加本地内存空间来满足类元数据信息的存储。但是如果没有设置最大值，则可能存在bug导致Metaspace的空间在不停的扩展，会导致机器的内存不足；进而可能出现swap内存被耗尽；最终导致进程直接被系统直接kill掉。如果设置了该参数，当Metaspace剩余空间不足，会抛出java.lang.OutOfMemoryError: Metaspace space
    -XX:MinMetaspaceFreeRatio，在GC之后，最小的Metaspace剩余空间容量的百分比，减少为分配空间所导致的垃圾收集。
    -XX:MaxMetaspaceFreeRatio，在GC之后，最大的Metaspace剩余空间容量的百分比，减少为释放空间所导致的垃圾收集。

### 12. 三种JVM

1. Sun公司  `HotSpot` 我们用的
2. BEA `JRockit`
3. IBM `J9 VM`

### 13. 堆内存调优

<img src="E:\notes\img\jvm3.png" alt="jvm3" style="zoom:50%;" />

- 方法一：设置vm方法 `-Xms1024m -Xmx1024m -XX:+PrintGCDetails`

  ```java
  public class TestGCDetails {
  
      public static void main(String[] args) {
          // 打印理想化最大内存
          long maxMemory = Runtime.getRuntime().maxMemory();
          System.out.println("打印理想化最大内存: " + maxMemory + " = " +  (maxMemory / (double) 1024 / 1024) + "m");
  
          // 打印实际总内存
          long totalMemory = Runtime.getRuntime().totalMemory();
          System.out.println("打印理想化最大内存: " + totalMemory + " = " +  (totalMemory / (double) 1024 / 1024) + "m");
  
          // 大约
          // 理想化最大内存 : 系统内存 == 1 : 4
          // 实际总内存 : 系统内存 == 1 : 64
  
  
          // -Xms1024m -Xmx1024m -XX:+PrintGCDetails
      }
  }
  ```

  ```java
  // -Xms1024m -Xmx1024m -XX:+PrintGCDetails
  public class TestOOM {
  
      public static void main(String[] args) {
          String str = "--";
  
          while (true) {
              str += str; // java.lang.OutOfMemoryError: Java heap space
          }
      }
  }
  ```

- 方法二：利用内存快照工具，MAT（eclipse集成），Jprofiler（一般使用）

  - 分析Dump内存文件，快速定位内存泄露；
  - 获取堆中的数据
  - 获得大的对象
  - ...进行分析
  

### 14. GC
- 常用算法
  
  1. 复制算法：
  
       - 在复制算法中，将内存分为两个区域（from to）
       - 在垃圾收集时，通过可达性分析找出所有存活的对象，然后复制到to区
       - 完成复制后，原来的区域被一次性回收，然后两个幸存区角色互换。
  
           好处：没有内存的碎片
  
           坏处：浪费了内存空间（幸存区），多一半的幸存空间永远是空。假设对象100%存活（极端情况，不适用复制算法）。
  
           最佳使用场景：对象存活率低，年轻代
  
  2. 标记-清除算法：
  
       - 在标记阶段，通过可达性分析标记处存活的对象。
  
       - 在清理阶段，将没被标记的对象视为垃圾，并且将其占用的内存空间回收。
  
           好处：不需要额外的内存空间。
  
           坏处：两次扫描，浪费时间，有内存碎片
  
  3. 标记-压缩算法：
  
       - 在标记阶段，通过可达性分析找出存活的对象，并标记
       - 在压缩阶段，将所有存活的对象移动到内存的一端，清理掉边界以外的内存空间。
  
           好处：不用额外的内存空间，无内存碎片
  
           坏处：时间成本增加。
  
- **内存效率：**复制算法 > 标记-清除算法 > 标记-压缩算法

- **内存整齐度：**复制算法 = 标记-压缩算法 > 标记-清除算法

- **内存利用率：**标记-压缩算法 = 标记-清除算法 > 复制算法

### 15. JMM -- Java Memory Model

java内存模型（JMM）是一套规范

#### 重排序

一种**模型融合策略**。**利用一种模型输出多个结果**而**不只是输出该模型意义下的最好结果**，==再利用其他模型==**对这些结果重新进行优劣评价和排序**，进而输出重新评价后的最好结果。

遵循规则：

1. heppens-before规则

   在多线程环境下，CPU追求性能，会对指令进行重排序，编译器也会优化代码的顺序，这就可能会导致程序执行的顺序和我们预期的代码顺序不一致，可能会出现线程问题，对数据的读取不一致等。这就利用到了heppens-before原则，约束了操作顺序，保证了线程安全，程序按照预期执行。

   定义：a操作heppens-before b操作    ，则a操作的执行结果堆b操作可见，并且a操作要在b操作之前执行，确保在**并发环境下**操作之间的依赖关系得到**正确的执行**和**可见性保证**。

   如果一个操作的执行结果对另外一个操作可见，那么这两个操作之间必然存在 happens-before 关系

   两个操作之间存在happens-before关系，不代表java的具体实现必须要按照happens-before规则的顺序来执行。**只要没有改变程序最后的执行结果，编译器和处理器怎么优化都行。**

   八大规则：

   1. 程序顺序规则（Program Order Rule） ：在一个线程内，按照代码顺序，前面的操作 happens-before 后面的操作。比如：

      ```java
      int a = 1;
      int b = 2;
      ```

      ​        这里，给变量 a 赋值的操作 happens-before 给变量 b 赋值的操作。这是单线程环境下最基本、好理解的规则。

   2. 监视器锁规则（Monitor Lock Rule） ：一个线程释放锁的操作 happens-before 另一个线程获取同一个锁的操作。比如多个线程抢同一把锁：

      ```java
      synchronized (lock) {
          // 临界区代码
      }
      ```

      ​        线程 A 执行完临界区代码释放锁，这个释放锁的操作 happens-before 线程 B 获取到这把锁的操作。这就保证了线程 A 在临界区内对共享变量的修改，对后续进入临界区的线程 B 可见。

   3. volatile 变量规则（Volatile Variable Rule） ：对一个 volatile 变量的写操作 happens-before 对另一个 volatile 变量的读操作。例如：

      ```java
      volatile boolean flag = false;
      
      // 线程 A
      flag = true;
      
      // 线程 B
      while (!flag) {
          // 等待 flag 变为 true
      }
      ```

      ​        线程 A 对 flag 变量的写操作 happens-before 线程 B 对 flag 变量的读操作，所以线程 B 能正确读到线程 A 修改后的 flag 值。

   4. 线程启动规则（Thread Start Rule） ：主线程 A 创建线程 B 并启动，主线程 A 的操作 happens-before 线程 B 的任何操作。比如：

      ```java
      public class Main {
          public static void main(String[] args) {
              int data = 1;
              Thread thread = new Thread(() -> {
                  // 使用 data
              });
              thread.start();
          }
      }
      ```

      ​        main 线程里对 data 的赋值操作 happens-before 新线程 thread 启动后使用 data 的操作。

   5. 线程终止规则（Thread Termination Rule） ：线程 A 完成所有操作并终止，这个终止操作 happens-before 其他线程检测到线程 A 已终止的操作。比如：

      ```java
      Thread thread = new Thread(() -> {
          // 做一些事情
      });
      thread.start();
      // 主线程等待 thread 结束
      thread.join();
      // thread.join() 返回，说明 thread 已终止
      ```

      ​        thread 线程执行完最后一条语句终止，这个终止操作 happens-before 主线程 thread.join() 返回，后续主线程就知道 thread 已结束。

   6. 中断规则（Interruption Rule）：调用线程的interrupt() happens-before 检测到中断（如抛出InterruptedException）。

   7. 对象终结规则（Finalizer Rule）：对象的构造函数结束 happens-before finalize()方法。

   8. 传递性（Transitivity） ：如果操作 A happens-before 操作 B，操作 B happens-before 操作 C，那操作 A happens-before 操作 C。这是组合使用上述规则时的关键补充。

2. as-if-serial规则

   无论如何重排序都不会改变单线程程序的执行结果。

   核心思想：编译器和处理器等各种层面的优化，都不能改变程序执行的意义。



### 单点登录~架构师 | SSO

![jvm11](E:\notes\img\jvm11.png)





