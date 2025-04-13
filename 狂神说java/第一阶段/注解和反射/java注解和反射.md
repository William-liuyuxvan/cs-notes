## 1. 注解 - Annotation

Annotation作用：

- 对程序做出解释
- 被其他程序读取
- 给编译器看的

格式：

- "@注释名" ，可以添加一些参数值，如：@SuppressWarning(Value="unchecked")

可以通过反射机制编程实现对元数据的访问。



## 2. 内置注解

- @override：定义在java.lang.Override中，此注释只适用于修辞方法，表示一个方法声明打算重写超类中的另一个方法声明.
- @Deprecated：定义在java.lang.Deprecated中，此注释可以用于修辞方法，属性，类，表示不鼓励程序员使用这样的元素，通常是因为它很危险或者存在更好的选择
- @SuppressWarnings：定义在java.lang.SuppressWarnings中，用来抑制编译时的警告信息
  - 与前两个注释有所不同，你需要添加一个参数才能正确使用，这些参数都是已经定义好了的，我们选择性的使用就好了.
  - @SuppressWarnings("all")
  - @SuppressWarnings("unchecked")
  - @SuppressWarnings(value={"unchecked","deprecation"})
  - 等等...



## 3. 元注解

**负责注解其他注解**

Java定义了4个标准的meta-annotation类型，他们被用来提供对其他annotation类型作说明。

这些类型和它们所支持的类在java.lang.annotation包中可以找到.（@Target，@Retention，@Documented , @lnherited )

- @**Target**：**用于描述注解的使用范围**（即:被描述的注解可以用在什么地方）
- @**Retention**：表示需要在什么级别保存该注释信息，用于**描述注解的生命周期**，**一般写RUNTIME**
  - (SOURCE<CLASS < **RUNTIME**)
- @Document：**说明该注解将被包含在javadoc中**
- @lnherited：**说明子类可以继承父类中的该注解**



## 4. 自定义注解

```java
@MyAnnotation()
public class Test01 {

    @MyAnnotation2("好")
    public void test2() {

    }
}

// 自定义注解
// 可以作用在类和方法上
@Target({ElementType.TYPE, ElementType.METHOD})
// 注解生存到运行时
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // 定义注解中的参数 : 类型 名称 + ()
    // 可以添加default来提示有默认值，在使用该注解时可以不用添加值
    String name() default "";
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 只有一个参数 建议用 value 命名，这样在使用的时候可以不用添加参数名进行使用
    String value();
}
```



## 5. 反射 - Reflection

Reflection（反射）是Java被视为动态语言的关键，反射机制允许程序在执行期借助于ReflectionAPI取得任何类的内部信息，并能直接操作任意对象的内部属性及方法。

~~~java
Class c = Class.forName("java.lang.String")
~~~

加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：**反射**

![Reflection01](E:\notes\img\Reflection01.png)



## 6. 获得反射对象

在Object类中定义了以下的方法，此方法将被所有子类继承

- public final Class getClass()

以上的方法返回值的类型是一个Class类，此类是Java反射的源头，实际上所谓反射从程序的运行结果来看也很好理Person类解，即：**可以通过对象反射求出类的名称**。

```java
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.base.reflection.one.User");

        System.out.println(c1.getName());
        Arrays.stream(c1.getFields()).forEach(System.out::println);
//        Arrays.stream(c1.getMethods()).forEach(System.out::println);
    }
}

class User {
    private String name;
    private String name1;
    private String name2;
    private String name3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```



## 7. Class类

对象照镜子后可以得到的信息：某个类的属性、方法和构造器、某个类到底实现了哪些接口。对于每个类而言，JRE都为其保留一个不变的Class 类型的对象。一个Class对象包含了特定某个结构(class/interface/enum/annotation/primitive type/void/[)的有关信息。

- Class 本身也是一个类
- Class 对象只能由系统建立对象
- 一个加载的类在 JVM 中只会有一个Class实例
- 一个Class对象对应的是一个加载到JVM中的一个.class文件
- 每个类的实例都会记得自己是由哪个Class实例所生成
- 通过Class可以完整地得到一个类中的所有被加载的结构
- Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象



## 8. 所有类型的Class对象

- lass：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类。
- interface：接口
- []：数组
- enum：枚举
- annotation：注解@interface
- primitivetype：基本数据类型
- void

只要元素类型与纬度一样，就是同一个Class

```java
public class Test02 {
    public static void main(String[] args) {
        int[] b = new int[10];
        int[] c = new int[20];
        System.out.println(b.getClass().hashCode()); // 356573597
        System.out.println(c.getClass().hashCode()); // 356573597


        int[][] b1 = new int[10][2];
        int[][] c1 = new int[20][2];
        System.out.println(b1.getClass().hashCode()); // 1735600054
        System.out.println(c1.getClass().hashCode()); // 1735600054
    }
}
```



## 9. 内存分析

1. 加载：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后生成一个代表这个类的java.lang.Class对象
2. 链接：将Java类的二进制代码合并到JVM的运行状态之中的过程。
   - 验证：确保加载的类信息符合JVM规范，没有安全方面的问题
   - 准备：正式为**常量、类变量（static）分配内存并设置类变量默认初始值的阶段**，这些内存都将在方法区中进行分配。
   - 解析：虚拟机常量池内的符号引用（**常量名**）替换为直接引用（地址）的过程。
3. 初始化:
   - 执行类构造器\<clinit\>(方法的过程。类构造器\<clinit\>(方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信息的，不是构造该类对象的构造器）。
   - 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。
   - 虚拟机会保证一个类的\<clinit\>()方法在多线程环境中被正确加锁和同步。

```java
/*
    1. 加载：加载到内存，产生类对应的Class对象
    2. 链接：将static分配内存，默认初始化
    3. 初始化：合并
            <clinit>() {
                System.out.println("static A");
                m = 4;
                m = 2;
            }
            m = 2;
 */
public class Test03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
    }
}

class A {

    static {
        System.out.println("static A");
        m = 4;
    }

    static int m = 2;

    public A() {
        System.out.println("初始化A");
    }
}
```



## 10. 类初始化

- 类的**主动引用**（一定会发生类的初始化）
  - 当虚拟机启动，先初始化main方法所在的类
  - new一个类的对象
  - 调用类的静态成员（除了final常量）和静态方法
  - 使用java.lang.reflect包的方法对类进行反射调用
  - 当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类
- 类的**被动引用** (不会发生类的初始化)
  - 当访问一个静态域时，只有真正声明这个域的类才会被初始化。如：当通过子类引用父类的静态变量，不会导致子类初始化
  - 通过数组定义类引用，不会触发此类的初始化
  - 引用常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中了）

```java
public class Test04 {

    public static void main(String[] args) {
        System.out.println(Son.m); // Father static ; 2
        System.out.println(Son.a); // Father static ;  2 ; Son static ; 3
        System.out.println(Son.B); // 1
        
        Son[] sons = new Son[2]; // 空
    }
}

class Father {
    static {
        System.out.println("Father static");
    }

    static int m = 2;
    
    static final int B = 1;
}

class Son extends Father {
    static {
        System.out.println("Son static");
    }

    static int a = 3;
}
```



## 11. 类加载器

==**作用**==：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后在堆中生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问入口。

==**类缓存**==：标准的JavaSE类加载器可以按要求查找类，但一旦某个类被加载到类加载器中，它将维持加载（缓存）一段时间。不过JVM垃圾回收机制可以回收这些Class对象

![Reflection02](E:\notes\img\Reflection02.png)

![Reflection03](E:\notes\img\Reflection03.png)

```java
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类加载器  用户类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获得系统类加载器的父类 --> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent(); // sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(parent);

        // 获取的扩展类加载器的父类 --> 引导类加载器  根加载器
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent); // null 不可获取 是由C/c++编写的
        
        // 获得Object类的加载器
        ClassLoader objectLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(objectLoader); // null 引导类加载器
        
        // 获取当前类加载器
        ClassLoader currentClassLoader = Class.forName("com.base.reflection.one.Test05").getClassLoader();
        System.out.println(currentClassLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\charsets.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\deploy.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\access-bridge-64.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\cldrdata.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\dnsns.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\jaccess.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\jfxrt.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\localedata.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\nashorn.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunec.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunjce_provider.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunmscapi.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunpkcs11.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\zipfs.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\javaws.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jce.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jfr.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jfxswt.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jsse.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\management-agent.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\plugin.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\resources.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\rt.jar;
            
            E:\notes\狂神说java\project\base\target\classes;
            E:\notes\狂神说java\project\base\lib\commons-io-2.18.0.jar;

            D:\soft\DevelopmentTools\JetBrains\idea\IntelliJ IDEA 2023.3.6\lib\idea_rt.jar
         */
    }
}
```

==**双亲委派机制（类加载机制）**==：如果自行定义了String类，会尝试在系统类加载器、扩展类加载器和根加载器中查找，如果有同名的类，则不会加载自行定义的类，确保了潜在的安全风险。

==**双亲委派机制（类加载机制）**==：在 Java 中，双亲委派机制是一种**类加载机制**，它确保了类加载的**安全性和稳定性**。当你尝试加载一个类时，这个请求**首先会委托给父类加载器**进行加载。**如果父类加载器无法完成加载任务，那么请求才会被传递给子类加载器**。这种机制可以**防止核心类库被篡改**，并且**确保了类的单一实例**。



## 12. 类运行时结构

获取运行时类的完整结构

通过反射获取运行时类的完整结构
Field、Method、Constructor、Superclass、 Interfaze、Annotation

**无Declare**的**只能获得public和父类的所有方法或者属性**，**有Declare**的**可以获得所有范围（public、protected、private）的本类的所有方法或者属性**

- 实现的全部接口
- 所继承的父类
- 全部的构造器
- 全部的方法
- 全部的Field
- 注解
- ......



## 13. 动态创建对象执行方法

创建类的对象：调用Class对象的newlnstance(方法
	1）类必须有一个无参数的构造器。
	2）类的构造器的访问权限需要足够

**思考？**难道没有无参的构造器就不能创建对象了吗？只要在操作的时候明确的调用类中的构造器，并将参数传递进去之后，才可以实例化操作。

步骤如下:
	1）通过Class类getDeclaredConstructor(Class ... parameterTypes)取得本类的指定形参类型的构造器
	2）向构造器的形参中传递一个对象数组进去，里面包含了构造器中所需的各个参数。
	3）通过Constructor实例化对象

==**调用指定的方法**==

通过反射，调用类中的方法，通过Method类完成。
	① 通过Class类的**getMethod**(String name,Class...parameterTypes)方法取得一个Method对象，并设置此方法操作时所需要的参数类型。
	② 之后使用Object **invoke**(Object obj, Object[] args)进行调用，并向方法中传递要设置的obj对象的参数信息。

![Reflection04](E:\notes\img\Reflection04.png)

==**Object invoke(Object obj, Object ... args)**==

- Object 对应原方法的返回值，若原方法无返回值，此时返回null
- 若原方法若为静态方法，此时形参Object obj可为null
- 若原方法形参列表为空，则Object[] args为nul
- 若原方法声明为private，则需要在调用此**invoke()方法前**，**显式调用方法对象的**
  **setAccessible(true)方法**，**将可访问private的方法**。

==**setAccessible**==

- **Method和Field、Constructor对象都有setAccessible(方法。**
- **setAccessible作用是启动和禁用访问安全检查的开关。**
- **参数值为true则指示反射的对象在使用时应该取消Java语言访问检查。**
  - **提高反射的效率。如果代码中必须用反射，而该句代码需要频繁的被调用，那么请设置为true。**
  - 使得原本无法访问的私有成员也可以访问
- 参数值为false则指示反射的对象应该实施Java语言访问检查



## 14. 性能测试对比：普通对象  反射对象  关闭检测反射对象

```java
public class Test06 {

    private static final int COUNT = 1000000000;

    // 普通方法
    public static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法循环10亿次：" + (endTime - startTime) + "ms");
    }

    // 反射方法
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("com.base.reflection.one.User");

        Method getName = c1.getMethod("getName", null);

        Object user = c1.newInstance(); // 调用无参构造器

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            getName.invoke(user,  null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法循环10亿次：" + (endTime - startTime) + "ms");
    }

    // 反射方法  关闭检测
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("com.base.reflection.one.User");

        Method getName = c1.getMethod("getName", null);

        Object user = c1.newInstance(); // 调用无参构造器
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            getName.invoke(user,  null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测反射方法循环10亿次：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        test01(); // 普通方法循环10亿次：3ms
        test02(); // 反射方法循环10亿次：1639ms
        test03(); // 关闭检测反射方法循环10亿次：1046ms
    }
}
```



## 15. 反射操作泛型

- Java采用泛型擦除的机制来引l入泛型，Java中的泛型仅仅是给编译器javac使用的，确保数据的安全性和免去强制类型转换问题，但是，一旦编译完成，所有和泛型有关的类型全部擦除

- 为了通过反射操作这些类型，Java新增了ParameterizedType，GenericArrayType，TypeVariable和WildcardType几种类型来代表不能被归一到Class类中的类型但是又和原始类型齐名的类型，

- ParameterizedType：表示一种参数化类型，比如Collection<String>
- GenericArrayType：表示一种元素类型是参数化类型或者类型变量的数组类型
- TypeVariable：是各种类型变量的公共父接口
- WildcardType：代表一种通配符类型表达式

```java
// 反射获取泛型
public class Test07 {

    public void test01(Map<String, User> map, List<Integer> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 获取test01中的参数泛型
        System.out.println("获取test01中的参数泛型");
        Method method = Test07.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("    *" + actualTypeArgument);
                }
            }
        }

        System.out.println("========================================");

        // 获取test02中的返回泛型
        System.out.println("获取test02中的返回泛型");
        method = Test07.class.getMethod("test02");
        Type genericReturnType = method.getGenericReturnType();

        System.out.println("#" + genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("    *" + actualTypeArgument);
            }
        }
    }
}
```



## 16. 反射操作注解

```java
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Student.class;

        System.out.println(c1); // class com.base.reflection.one.Student

        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        /*
            @com.base.reflection.one.TableLiu(value=db_student)
         */

        // 获取annotation中的值
        TableLiu tableLiu = (TableLiu) c1.getAnnotation(TableLiu.class);
        System.out.println(tableLiu.value()); // db_student

        // 获取属性中的注解信息
        Field id = c1.getDeclaredField("id");
        System.out.println(id); // private int com.base.reflection.one.Student.id
        FieldLiu fieldLiu = id.getAnnotation(FieldLiu.class);
        System.out.println(fieldLiu.columnName()); // db_id
        System.out.println(fieldLiu.type()); // int
        System.out.println(fieldLiu.length()); // 10

    }
}

@TableLiu("db_student")
class Student {
    @FieldLiu(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldLiu(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldLiu(columnName = "db_name", type = "varchar", length = 5)
    private String name;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLiu {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldLiu {
    String columnName();
    String type();
    int length();
}
```











