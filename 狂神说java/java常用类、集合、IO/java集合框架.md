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

------

## List 集合

**特点**：有序、可重复、有索引

**经典代码**：List\<E> list = new ArrayList\<>();

**方法**：

- void add(int index,E element)  在此集合中的指定位置插入指定的元素
- E remove(int index)  删除指定索引处的元素，**返回被删除的元素**
- E set(int index,E element)  修改指定索引处的元素，**返回被修改的元素**
- E get(int index)  返回指定索引处的元素

**遍历**：

- for循环 --> list中有索引
- 迭代器
- 增强for
- lambda表达式
- 

**ArrayList** 和 **LinkedList** 底层采用的**数据结构不同**，**应用场景不同**。 

----

### ArrayList 集合底层原理

基于**数组**实现的：**查询快、增删慢**（查询时直接利用起始地址加上index，增删时需要移动后面的数据）

**原理**：

1. 利用无参构造器时，在底层创建一个默认长度为0的数组。
2. 当添加第一个元素时，底层创建一个新的长度为10的数组。
3. 当存满时，并且还需要存的时候为扩容1.5倍。
4. 如果一次性添加多个元素（如用 addAll() 方法时），1.5倍放不下时，会创建一个大小与添加后大小相同的数组。

**应用场景**：

1. 适合场景：
   - 根据索引查询数据（根据随机索引取数据），或者数据量不是很大时。
2. 不适合场景：
   - 数据量大的同时，又要频繁进行增删操作。

---

### LinkedList集合底层原理

基于**双链表**实现：**查询慢、增删快（相对于数组）**

 java中大多情况下都是使用双向链表：查询慢、增删相对较快、但**对首尾元素进行增删改查的速度是极快的**。

**方法**----很多首尾操作方法：

- public void addFirst(E e)  在该列表开头插入指定的元素
- public void addLast(E e)  将指定的元素追加到此列表的末尾
- public E getFirst()  返回此列表中的第一个元素
- public E getLast()  返回此列表中的最后一个元素
- public E removeFirst()  从此列表中删除并返回第一个元素
- public E removeLast()  从此列表中删除并返回最后一个元素

 **应用场景**：

1. 设计队列：先进先出（addLast()、removeFirst()）
2. 设计栈：先进后出（push() -> addFirst()、pop() -> remove()）

-------

## Set 集合 ------ 基本上就是Collection提供的，几乎没有额外新增一些常用功能

**特点**：**无序、不重复、无索引**

**经典代码**：Set\<E> set = new HashSet\<>();

1. HashSet --> 无序、不重复、无索引
2. LinkedHashSet --> **有序**、不重复、无索引
3. TreeSet --> **可排序，默认升序**、不重复、无索引

------

### HashSet 集合的底层原理

基于**哈希表**实现。

哈希表是一种增删改查数据，性能都较好的数据结构。

**预前知识** ---- 哈希值：由Object类的hashCode()提供，由于是int类型（-21亿多~21亿多），因此不同对象的哈希值一般不同，但也有可能相同（哈希碰撞 -- 概率很小）。

**哈希表**：

- JDK8 之前，哈希表 = 数组 + 链表
  1. 创建一个默认长度为16的数组，默认**加载因子为0.75**（当数组长度达到 16 * 0.75 = 12 时，就会对数组进行扩容，一般为2倍扩容），数组名叫table。
  2. 使用元素的**哈希值**和**数组的长度求余**计算出应存入的位置。
  3. 判断当前位置是否为null，如果是null直接存入。
  4. 如果不为null，表示有元素，则调用equals方法比较：相等，则不存；不相等，则存入数组
     - JDK8 之前，新元素存入数组，占老元素位置，老元素挂下面。
     - JDK8 之后，新元素直接挂在老元素下面。
- JDK8 之后，哈希表 = 数组 + 链表 + **红黑树** ----- 当链表长度超过8，且数组长度 >= 64 时，自动将链表转成红黑树。

Java中基本上用的都是**平衡二叉树**。

**红黑树**：可以自平衡的二叉树。

**注意**：Set集合中对于两个内容相同的不同对象是不能去重复的，因为用的是hashCode()进行比较，因此如果希望去重复，需要使内容相同的不同对象hashCode()必须相同，所以需要重写equals()方法和hashCode()方法。

~~~java
// 重写equals()方法和hashCode()方法。
// 实现equals()方法中的instanceof和getClass()都是相同的目的。
// @Override
// public boolean equals(Object o) {
//     if (this == o) return true;
//     if (o == null || getClass() != o.getClass()) return false;
//     Student student = (Student) o;
//     return age == student.age && sex == student.sex && Objects.equals(name, student.name);
// }

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    Student student = (Student) o;
    return age == student.age && sex == student.sex && Objects.equals(name, student.name);
}

@Override
public int hashCode() {
    return Objects.hash(name, age, sex);
}
~~~



-----

### LinkedHashSet 集合

基于哈希表**（数组、链表、红黑树）**实现，但是**每个元素都额外多了一个双链表的机制记录它前后元素的位置**。

其中有两个变量分别指向头节点和尾节点位置

对于增删查改性能都比较好，但是较于HashSet而言，更占内存（多了一个双链表），但是能够记住添加的顺序。

-----

### TreeSet 集合

**可排序（默认升序 ---> 基于红黑树）、不重复、无索引**

 **注意**：

- 对于数值类型：Integer，Double，默认按照数值本上大小进行升序排序
- 对于字符串类型：默认按照首字符的编号升序排序
- **对于自定义类型如Student对象，TreeSet默认无法直接排序，需要Student继承Comparable接口重写compareTo或者在TreeSet有参构造器设置Comparator对象实现比较规则**
- 在两个比较方法都实现的情况下， 优先使用TreeSet有参构造器中的实现方法。

~~~java
// 方法一：重写Comparable接口中的compareTo
@Override
public int compareTo(Object o) {
    return this.age - ((Student) o).age == 0 ? this.name.compareTo(((Student) o).name) : this.age - ((Student) o).age;
}

// 方法二：在TreeSet有参构造器设置Comparator对象实现比较规则  ---- 利用lambda表达式
TreeSet<Student> set = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge());
~~~

----

## Collection 集合小结

1. 如果希望**记住元素的添加顺序**，**需要存储重复的元素**，又要频繁的**根据索引查询数据**？
   - 用**ArrayList**集合（有序、可重复、有索引l），底层基于**数组**的。**（常用）**
2. 如果希望**记住元素的添加顺序**，且**增删首尾数据**的情况较多？
   - 用**LinkedList**集合（有序、可重复、有索引l），底层基于**双链表**实现的。
3. 如果**不在意元素顺序**，也**没有重复元素**需要存储，只希望**增删改查都快**？
   - 用**HashSet**集合（无序，不重复，无索引l），底层基于**哈希表**实现的。**（常用）**
4. 如果希望**记住元素的添加顺序**，也**没有重复元素**需要存储，且**希望增删改查都快**？
   - 用**LinkedHashSet**集合（有序，不重复，无索引l），底层基于**哈希表和双链表**。
5. 如果**要对元素进行排序**，也**没有重复元素**需要存储？且**希望增删改查都快**？
   - 用**TreeSet**集合，基于**红黑树**实现。

----

## 补充说明：集合的并发修改异常

在进行集合的修改时，不如删除数据时，会将数组的大小缩小并且前移数据，因此删除数据时，并不能完全遍历完整个数组，导致漏删，并且出现并发修改异常的错误（ConcurrentModificationException）。

- 使用迭代器遍历集合时，同时又在删除数据，程序会出现并发修改异常的错误（ConcurrentModificationException）。
- 增强for循环就是简化版的迭代器遍历集合写法，因此使用增强for也会出现报错。

**解决方法**：

- 使用迭代器：用迭代器提供的删除方法。底层也是做了 i-- 操作。
- 使用简单for循环：倒着遍历删除；或者正着遍历，在删除数据后进行 i-- 操作。

~~~java
ArrayList<String> list = new ArrayList<>();
list.add("王麻子");
list.add("小李子");
list.add("李爱花");
list.add("张全蛋");
list.add("小李");
list.add("李玉刚");
System.out.println(list);

// --------------错误写法---------------------
// 错误方法1：使用普通for循环删除 --- 删除了数据之后，数组后面的数据向前移，导致有些数据无法识别
for (int i = 0; i < list.size(); i++) {
    if (list.get(i).contains("李")) {
        list.remove(i);
    }
}
System.out.println(list); // [王麻子, 李爱花, 张全蛋, 李玉刚]

// 错误方法2：使用迭代器 ---- ConcurrentModificationException
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String name = it.next();
    if (name.contains("李")) {
        list.remove(name);
    }
}
System.out.println(list);

// --------------正确写法---------------------
// 正确方法1：普通for 删除后--
for (int i = 0; i < list.size(); i++) {
    if (list.get(i).contains("李")) {
        list.remove(i);
        i--;
    }
}
System.out.println(list);

// 正确方法2：普通for 倒着删除
for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i).contains("李")) {
        list.remove(i);
    }
}
System.out.println(list);

// 正确方法3：利用迭代器中的remove()方法 --- 在remove()方法中也进行了i--操作
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String name = it.next();
    if (name.contains("李")) {
        it.remove();
    }
}
System.out.println(list);

// --------------无法修改的错误写法---------------------
// 无法原谅方法1：增强for (简化版迭代器) ------ ConcurrentModificationException
for (String name : list) {
    if (name.contains("李")) {
        list.remove(name);
    }
}
System.out.println(list);

// 无法原谅方法2：使用lambda ----- ConcurrentModificationException
list.forEach(name -> {
    if (name.contains("李")) {
        list.remove(name);
    }
});
~~~















