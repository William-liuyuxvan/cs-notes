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























