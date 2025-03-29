## 集合体系结构 --- 集合中存储的是地址

1. Cellection\<E>接口：单列结合，约定了基本特点，增删改查
   1. List\<E>接口 **增加索引**：添加的元素是**有序、可重复、有索引**
      - Arraylist\<E>实现类
      - LinkedList\<E>实现类
   2. Set\<E>接口：添加的元素是**无序、不重复、无索引**
      1. HashSet\<E>实现类
         - LinkedHashSet\<E>实现类：**有序**
      2. TreeSet\<E>实现类：**按照大小默认升序排序**
2. Map\<K, V>接口：双列集合（键值对），**键不能重复，值可以重复，一一对应**
   1. HashMap\<K, V>实现类：**无序、（key）不重复、无索引（用的最多）**
      - LinkedHashMap\<K, V>实现类：**有序**
   2. TreeMap\<K, V>实现类：**按照（key）大小默认升序排序**
   3. ...

----

## Collection ------ 泛型在运行阶段已经擦除了，可能存在添加的元素并不是指定类型元素 -> 对应方法 toArray() 的返回类型

### 常用API

- public boolean add(E e)  把给定的对象添加到当前集合中
- public void clear()  清空集合中所有的元素
- public boolean remove(E e)  把给定的对象在当前集合中删除
- public boolean contains(object obj)  判断当前集合中是否包含给定的对象
- public boolean isEmpty()  判断当前集合是否为空
- public int size()  返回集合中元素的个数。
- public Object[] toArray()  把集合中的元素，存储到数组中

~~~java
// 存在Collection<String> c = ArrayList()<>;
// 方法1
Object[] obj = c.toArray();
// 方法2
String[] strArr = c.toArray(new String[c.size()]); // 需要保证添加的元素只能是 String类型
~~~

### 遍历方法--迭代器

**选代器是用来遍历集合的专用方式**（数组没有迭代器)，在Java中迭代器的代表是**lterator**

**Collection集合获取迭代器的方法**：

- Iterator\<E> iterator()   返回集合中的迭代器对象，该迭代器对象默认指向当前集合的第一个元素

**Iterator选代器中的常用方法**：

- boolean **hasNext()**   询问**当前位置是否有元素存在**，存在返回true，不存在返回false方法名称
- E **next()**   **获取当前位置的元素**，并同时**将迭代器对象指向下一个元素处**。// 报错为NoSuchElementException

### 遍历方法--增强 for  --> 遍历集合或者数组

~~~java
for (元素的数据类型 变量名 : 数组或者集合) {
    
}
~~~

### 遍历方法--lambda 表达式

JKD 8 的新技术

~~~java
// 存在 Collection<String> c = new ArrayList<>();
// 匿名内部类
c.forEach(new Consumer<String s>() {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
});

// lambda表达式格式为：() -> {}
c.forEach((String s) -> {
        System.out.println(s);
    }
);
// 数据类型可以省略
c.forEach((s) -> {
        System.out.println(s);
    }
);
// 如果数据类型只有一个 那么小括号可以省略
c.forEach(s -> {
        System.out.println(s);
    }
);
// 如果方法体中只有一行，那么大括号 return ; 可以省略
c.forEach(s -> System.out.println(s));

// "lambda" 结合 "方法引用"：前后参数一样
c.forEach(System.out::println);s
~~~

















