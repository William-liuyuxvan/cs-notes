## 内部类

在一个类的内部再定义一个完整的类。

~~~java
class Outer {
    class Inner {
    }
}
// 编译后class文件如下：
/* 
Outer$Inner.class
Inner.class
*/
~~~

**分类**：

1. 成员内部类
2. 静态内部类
3. 局部内部类
4. 匿名内部类

**特点**：

- 编译后可以生成独立的字节码文件。
- 内部类可以访问外部类的私有成员，并且不破坏封装。
- 内部类可以为外部类提供功能组件。

----

### 成员内部类

**声明方式**：

~~~java
// 第一种
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();

// 第二种
Outer.Inner inner2 = new Outer().new Inner();
~~~

**特点说明**：

- 如果内部类和外部类属性重名，则在内部类中优先访问内部类。如果需要访问外部类属性 `Outer.this.属性`，为了提高阅读性，在内部访问内部类属性的时候可以加入 `this.属性`
- 成员内部类不能定义静态成员，但是可以有静态常量。

-------

### 静态内部类

**构造方式**：

~~~java
class Outer {
    static class Inner {
    }
}
~~~

**声明方式**：

可以直接创建内部类实例。

~~~java
Outer.Inner inner = new Outer.Inner();
~~~

**说明**：

- 只有内部类才能用 static 进行静态修饰，普通类无法用 static
- 静态内部类中可以存在静态成员。
- 如果要调用外部类成员，需要实例化一个外部类对象才能进行访问，因为静态内部类声明就创建，而外部类需要定义才能拥有属性和方法。

----

### 局部内部类

定义在方法里，只能在当前方法中使用。

**构造方法**：

~~~java
class Outer {
    public (static) void method() {
        class Inner {
        }
    }
}
~~~

**声明方式**：

只能在该方法中进行声明，其他地方不能声明定义。

~~~java
public void show() {
    String address = "beijing";

    class Inner {
        private int phone = 111;

        public void show() {
            System.out.println(Outer.this.name);
            System.out.println(Outer.this.age);
            System.out.println(this.phone);
            System.out.println(address);
        }
    }

    Inner inner = new Inner();
    inner.show();
}
~~~

**说明**：

- **局部内部类不能加任何修饰符**
- 内部类在对方法中的成员进行访问的时候，必须是 final 常量属性。**在 jdk1.7 中必须手动加入 final，在 jdk1.8 中自动加入final。**（因为在方法使用完成后就不会占用空间，但是内部类声明定义后会占用内存空间，如果内部类中访问的属性不是常量，那会随着方法的消失而消失，因此访问的属性必须是常量）
- **在内部类中定义static属性时，必须加入 final。**（因为如果在方法中直接访问 static 属性，那么不用定义内部类，但是内部类不定义会随着方法的消失而消失，如果是 static 无 final，就会导致一直存在在内存中，引发报错。）

------

### 匿名内部类

顾名思义，没有名字的内部类，一切特征都与局部内部类相同。

**必须继承一个父类或者实现一个接口**

~~~java
public class Application {
    public static void main(String[] args) {
        /*ImpExample imp = */new ImpExample() {
            @Override
            public void service() {
                // TODO
                // ...
            }
        }
        /*imp.service();*/
    }
}
~~~

**说明**：

- 优点：减少代码量
- 缺点：可读性较差
- 匿名内部类并不是完全没有名字，系统帮助起了名字，如上述实现的匿名内部类在编译后 class 文件为 `Application$1.class`

-----

## Object 类

超类、基类，所有类都直接或者间接继承 Object 类，位于继承树的最顶层。

- 所有类都默认继承 Object 类。
- 基类中的所有方法，所有对象都具备。
- Object 类型可以存储任何对象。
  - 作为**参数**，可接受任何对象。
  - 作为**返回值**，可返回任何对象。

-----

### getClass() 方法

~~~java
public final native Class<?> getClass();
~~~

返回引用中存储的**实际对象类型**。

**应用**：用于判断两个引用中实际存储对象类型是否一致。

----

### hashCode() 方法

~~~java
public native int hashCode();
~~~

返回该对象的**哈希码值**。

- **哈希值**：根据对象的地址或者字符串或者数字使用 hash 算法计算出来的int类型的数值。

- 一般情况下，相同对象返回相同的哈希码。

---

### toString() 方法

~~~java
public String toString() {
	return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
~~~

返回该对象的字符串表示。

------

### equals() 方法

~~~java
public boolean equals(Object obj) {
    return (this == obj);
}
~~~

**默认实现：this == obj，比较的是两个对象地址是否相同。**

一般进行覆盖，比较两个对象的内容是否覆盖。

**覆盖步骤**：

1. 比较两个引用是否指向同一个对象，既是是否为同一地址（this == obj）。
2. 判断 obj 是否为 null（obj == null）。
3. 判断两个引用指向的实际对象类型是否一致（obj instanceof 该类）。
4. 强制类型转换（ (该类)obj ）。
5. 依次比较各属性值是否相同。

------

### finalize() 方法

当对象被判断为垃圾对象时，**JVM自动调用此方法**，用来标记垃圾对象，进入回收队列。

- 垃圾对象：没有有效引用指向此对象时，为垃圾对象。
- 垃圾回收：由 GC 销毁垃圾对象，释放数据存储空间。
- 自动回收机制：JVM内存耗尽，一次性回收所有垃圾对象。
- **手动回收机制**（程序员只能用该方法，不能直接执行 finalize() ）：使用 **System.gc()**，通知JVM执行垃圾回收。

~~~java
public class Application {
    public static void main(String[] args) {
        new Student(1, "xiaohong", 18);
        new Student(2, "xiaoming", 20);
        new Student(3, "xiaozhang", 30);
        new Student(4, "xiaozhao", 11);

        System.gc();
        System.out.println("回收垃圾成功。");
    }
}
~~~

----

#### 关于GC（Garbage Collection）的一些说明

GC是java中垃圾回收机制，自动管理内存。

**System.GC() 只是一种建议**，建议JVM运行垃圾回收方法，但是JVM会自动判断是否该进行垃圾回收。并且不建议多次使用该方法，会影响JVM的判断。

**GC工作原理**：

1. **标记阶段**：GC遍历所有可达对象，并且标记为“存活”。
2. **清除阶段**：GC遍历堆内存，回收未被标记的对象占用的内存空间。
3. **整理阶段**（可选）：某些垃圾回收算法（如压缩算法）会将存活对象移动到内存的一端，减少内存碎片。

----

## 包装类

基本数据类型所对应的引用数据类型。

由于基本类型并没有方法可以使用，只是一个数值存在，与因此将它们包装起来以便使用基本方法。

**引用数据类型的默认值是 null**

~~~java
Byte Short Integer Long Float Double Boolean Character
~~~

-----

## 类型转换中装箱、拆箱

**装箱**：将基本类型转换成引用类型------将值从栈中放入堆中。

**拆箱**：将引用类型转换成基本类型------将值从堆中放入栈中。

~~~java
int testNum = 10;
// JDK1.5之前，“手动”装箱、拆箱
// 装箱
// 方法1
Integer integer1 = new Integer(testNum);
// 方法2
Integer integer2 = Integer.valueOf(testNum);
// 拆箱
int num1 = integer1.intValue();

// JDK1.5之后，“自动”装箱、拆箱
// 自动装箱  编译器(显示)自动转换成Integer.valueOf(testNum)
Integer integer3 = testNum;
// 自动拆箱  编译器并没有显示完成转换，但是在JVM层面中自动调用了Integer.intValue()方法
int num2 = integer3;
~~~

8种包装类提供不同类型间的转换方式：

- Number父类种提供的6种共性方法。

~~~java
byte byteValue() // 将指定数字的值作为 byte 返回。
abstract double doubleValue() // 将指定数字的值作为 double 返回。
abstract float floatValue() // 将指定数字的值作为 float 返回。
abstract int intValue() // 将指定数字的值作为 int 返回。
abstract long longValue() // 将指定数字的值作为 long 返回。
short shortValue() // 将指定数字的值作为 short 返回。
~~~

- parseXXX() 静态方法---在8大引用类型中。

- valueOf() 静态方法---在8大引用类型中。

**注意**：需要保证类型兼容，否则会抛出NumberFormatException。

- Integer.parseInt(String str)：str不能含有数值以外的值。
- Boolean.parseBoolean(String str)：“true”则为true，非“true”则为false。

------

## Integer 整数缓冲区

Java预先在缓冲区创建好了256个（-128~127）常用的整数包装类型对象。以便于服用，节约时间和空间。

~~~java
Integer integer1 = new Integer(100);
Integer integer2 = new Integer(100);
System.out.println(integer1 == integer2);
Integer integer3 = 100; // 自动装箱Integer.valueof
Integer integer4 = 100;
System.out.println(integer3 == integer4); // true 预先在堆中创建了-128~127整形对象
Integer integer5 = 200; // 自动装箱
Integer integer6 = 200;
System.out.println(integer5==integer6); // false
~~~

在Integer.valueOf(int i)中代码如下：

~~~java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)]; // 在cache数组中创建了-128~127整形对象
    return new Integer(i);
}
~~~

-----

## String 类

字符串是常量，创建之后不可改变（固定地址的值不能改变，但对象可以改变地址以达到改变值）。

字符串字面值是存储在**字符串池（方法区中）**中，**可以共享**。

~~~java
String name = "hello"; // "hello"常量存储在字符串池中，栈中 name 直接指向字符串池中的"hello"所在地址
String name2 = "hello"; // 与上面 name 指向地址相同
name == name2 // true

String str = new String("java"); // 先在字符串池中创建"java"常量，然后在堆中创建对象，栈中的 str 指向堆中的地址，然后堆中的地址再指向字符串常量中的地址。
String str2 = new String("java"); // 先在字符串池中查找有无"java"常量，如无就创建该常量。在堆中创建对象，然后指向该常量地址，栈中 str2 再指向堆中地址。
str == str2 // false
~~~

一般的字符串比较是否相同用 equals() 方法。

**常用方法**：

- public int length()：返回字符串的长度。

- public char charAt(int index)：根据下标获取字符。

- public boolean contains(String str)：判断当前字符串中是否包含str。

- public char[］toCharArray()：将字符串转换成数组。

- public int indexOf(String str)：查找str首次出现的下标，存在，则返回该下标；不存在，则返回-1。

- public int lastIndexOf(String str)：查找字符串在当前字符串中最后一次出现的下标索引。

- public String trim()：去掉字符串前后的空格。

- public String toUpperCase()：将小写转成大写。

- public boolean endWith(String str)：判断字符串是否以str结尾。

- public String replace(char oldChar, char newChar)：将旧字符串替换成新字符串

- public String[] split(String str)：根据str做拆分。

  ~~~java
  // 在 public String[] split(String str); 方法中可以使用正则表达式
  String say = "java is the best    programing language, java xiang";
  // 利用split方法分为每个单词
  String[] arr = say.split(" ");
  System.out.println(Arrays.toString(arr)); // [java, is, the, best, , , , programing, language,, java, xiang]
  
  String[] arr2 = say.split("[ ,]"); // [ ,] 表示在" "或","分开
  System.out.println(Arrays.toString(arr2)); // [java, is, the, best, , , , programing, language, , java, xiang]
  
  String[] arr3 = say.split("[ ,]+"); // [ ,]+ 表示在所有" "或","分开
  System.out.println(Arrays.toString(arr3)); // [java, is, the, best, programing, language, java, xiang]
  ~~~

**案例练习**：

~~~java
/*
已知String str = "this is a text";
1.将str中的单词单独获取出来
2.将str中的text替换为practice
3.在text前面插入一个easy
4.将每个单词的首字母改为大写
*/
String str = "this is a text";

// 1.将str中的单词单独获取出来
String[] arrString = str.split(" ")

// 2.将str中的text替换为practice
String str2 = str.replace("text", "practice");

// 3.在text前面插入一个easy
String str3 = str.replace("text", "easy text");

// 4.将每个单词的首字母改为大写
String[] arrString = str.split(" ")
String new = "";
for (int i = 0; i < arrString; i++) {
    char first = arrString[i].charAt(0);
    
    char upperFirst = Character.toUpperCase(first); 
    
    new += upperFirst + arrString[i].substring(1) + " ";
}
new = new.substring(0, new.length() - 1);

~~~

---

## 可变字符串

由于String类不可变性，每次更改都会产生新的内存来存储，空间开销大，产生垃圾，效率低，因此提供了可变字符串

- StringBuffer：JDK1.0提供，运行效率慢，线程安全。先开辟一个缓冲区进行操作。
- StringBuffer：JDK5.0提供，运行效率快，线程不安全。**如果是单线程就用StringBuffer。**

1. StringBuffer
   - append(String str)  追加字符串str
   - insert(int index, String str)  在 index 前插入 str
   - replace(int start, int end, String str)  将 start 到 end - 1 替换为str **（含头不含尾）**
   - delete(int start, int end)  将 start 到 end - 1 删除 **（含头不含尾）**

2. **StringBuffer  方法与 StringBuffer 一样，但是单线程用 StringBuffer**

-----

## BigDecimal

float 和 double 存储的是近似值，并不是实际值，可能经过运算或者转换之后导致误差，因此用 BigDecimal 来精确计算浮点数。

**运用 BigDecimal 一定要用字符串进行创建。**
`BigDecimal bd = new BigDecimal("1.0")`

**方法**：

- BigDecimal add(BigDecimal bd)  加
- BigDecimal subtract(BigDecimal bd)  减
- BigDecimal multiply(BigDecimal bd)  乘
- BigDecimal divide(BigDecimal bd)  除

当使用divide方法时，可能报错，**原因是因为除不尽**，那就用参数divide的重载方法来进行解决。

- 除法: divide (BigDecimal bd, int scal, RoundingMode mode)
- **参数scal**：指定精确到小数点后几位。
- **参数mode**：
  - 指定小数部分的取舍模式，通常采用四舍五入的模式
  - 取值为BigDecimal.ROUND_HALF_UP。

-----

## Date

 **基准时间（纪年）**：1970年1月1日 00:00:00 GMT，Unix操作系统在1969年创建，1970年称为Unix元年。

JDK1.0提供，表示特定的瞬间，精确到毫秒。**Date类（考虑不周全）中的大部分方法都被Calendar类（JDK1.1提供）中的方法取代。**

10^3换算规则：秒 -> 毫秒 -> 微秒 -> 纳秒

**方法**：

- new Date()  设置当前时间

- new Date(long date)

- boolean after(Date when)  是否在指定日期之后

- boolean before(Date when)  是否在指定日期之前

- int compareTo(Date anotherDate)  比较两个日期以进行排序。

- boolean equals(Object obj)  比较两个日期是否相等。

---

 ## Calendar

**构造方法不可使用**，因为 protected Calendar() 修饰符是protected，无法直接创建该对象。

用静态方法 getInstance() 进行创建。

**其他方法**：

- static Calendar getlnstance()  使用默认时区和区域获取日历
- voidSet(int year,int month,int date,int hourofday,int minute,int second)  设置日历的年、月、日、时、分、秒。
- int get(int field)  返回给定日历字段的值。字段比如年、月、日等
- void setTime(Date date)  用给定的Date设置此日历的时间。Date-Calendar
- Date getTime()  返回一个Date表示此日历的时间。Calendar-Date
- void add(int field,int amount)  按照日历的规则，给指定字段添加或减少时间量
- long getTimelnMillies()  毫秒为单位返回该日历的时间值













