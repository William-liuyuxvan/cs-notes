## 面向对象

- **以类的方式组织代码，以对象的方式组织（封装）数据**
- 抽象
- 三大特性：**封装、继承、多态**

备注：... -> 定义可变量参数

---

## 方法中的小知识

- static是随着方法的产生而产生，只要方法在，static所在类或者参数就在；而非static是随着对象的定义才产生。

---

## 构造器

- 当存在有参构造器时，不会自动生成无参构造器，需要显示存在无参构造器。

---

## 封装 -> 属性私有，get/set

追求”**高内聚，低耦合**“

1. 高内聚：类中的内部数据操作由自己完成，不允许外部干涉。
2. 低耦合：暴露少量方法给外部使用。

优点：

1. 提高数据的安全性，保护数据
2. 隐藏代码的实现细节
3. 统一接口
4. 增加可维护性

-----

**ctrl + H --> 展示继承树结构**

---

## 重写

- 修饰符：范围可以扩大但不能缩小： public > protected > default > private
- 抛出的异常：范围可以缩小但不能扩大。

---

## 多态 ---> 方法的多态，属性没有多态

父类的引用指向子类  `Person s = new Student()`

---

 **被 final 修饰的类不能被继承**

-----

## 抽象类-单继承   接口-多继承

#### 抽象类（约束） ----> 具体实现和规范(抽象方法)都有

- 不能new抽象类，只能靠子类去实现
- 抽象类中可以写普通的方法
- 抽象方法必须在抽象类中

#### 接口 （规范）   -----> 只有规范      约束和实现分离

---

## 内部类

在一个类中定义一个类。

1. 成员内部类：

~~~java
public class Outter {
    class Inner {
        public void print(){};
    }
}
~~~

在同一个java文件中，只能有一个public类

~~~java
public class PublicClass {
}

class SecondClass {
}
~~~

2. 静态内部类

~~~java
public class Outter {
    public static class Inner {
        public void print(){};
    }
}
~~~

3. 局部内部类

~~~java
public class Outter {
    public void method() {
        public class Inner {
        	public void print(){};
    	}
    }
}
~~~

4. 匿名内部类

~~~java
public class Outter {
	public static void main(String[] args) {
        // 第一种匿名内部类
        new Apple().print();
        
        // 第二种匿名内部类
        UserService userService = new UserService() {
            @Override
            public void hello() {
                // 实现方法体 
                //...
            }
        }
    }
}

class Apple {
    public void print(){};
}

interface UserService() {
    void hello();
}
~~~

