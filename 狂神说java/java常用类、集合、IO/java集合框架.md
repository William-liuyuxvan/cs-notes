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

### ArrayList -- 有序、可重复 、有索引

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

### LinkedList -- 有序、可重复 、无索引

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

### HashSet -- 无序、不重复 、无索引

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

### LinkedHashSet -- 有序、不重复 、无索引

基于哈希表**（数组、链表、红黑树）**实现，但是**每个元素都额外多了一个双链表的机制记录它前后元素的位置**。

其中有两个变量分别指向头节点和尾节点位置

对于增删查改性能都比较好，但是较于HashSet而言，更占内存（多了一个双链表），但是能够记住添加的顺序。

-----

### TreeSet -- 可排序、不重复 、无索引

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

----

## 可变参数 -> "数据类型...参数名称"

就是一种特殊参数，定义在方法、构造器中的形参中。

**特点**：可以不传数据，可以传一个或多个，可以传数组。

**好处**：常常用来灵活的接收数据。

**注意事项**：

- **可变参数在方法中就是一个数组的形式。**
- 一个方法中只能存在一个可变参数。
- 可变参数只能放在形参列表的最后面。

~~~java
public static void main(String[] args) {
    test(); // 0 []
    test(10); // 1 [10]
    test(10, 20, 30, 40); // 4 [10, 20, 30, 40]
    test(10, 20, 30, 40); // 4 [10, 20, 30, 40]
}

public static void test(int... nums) {
    System.out.println(nums.length);
    System.out.println(Arrays.toString(nums));
}
~~~

-----

## Collections 工具类

一个用来操作集合的工具类

**常用方法**：

~~~java
List<Integer> list = new ArrayList<>();

// public static <T> boolean addAll(collection<? super T> c, T...elements)：给集合批量添加元素
Collections.addAll(list, 10, 10, 20, 30, 40);
System.out.println(list); // [10, 10, 20, 30, 40]

// public static void shuffle(List<?>list)：打乱List集合中的元素顺序
Collections.shuffle(list);
System.out.println(list); // [30, 20, 10, 40, 10]


// public static<T> void sort(List<T> list)：对List集合中的元素进行升序排序
Collections.sort(list);
System.out.println(list); // [10, 10, 20, 30, 40]

// public static<T> void sort(List<T>list,Comparator<? super T> c)：对List集合中元素，按照比较器对象指定的规则进行排序
// Collections.sort(list, Collections.reverseOrder()); // [40, 30, 20, 10, 10]
Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1)); // [40, 30, 20, 10, 10]

/*
对于自定义类 如Student时，1. 需要在Student类中实现Comparable接口中的compareTo方法
或者 2. 直接在参数Comparator<? super T> c重写方法
 */
System.out.println(list);
~~~

-----

## Map

双列集合，一次需要存一对数据

key=value  一个键值对/键值对对象/一个Entry对象 ----- Map集合也叫“键值对集合”

**键可以重复，值不能重复。**

**特点**：Map集合的特点是由键决定的，值只是一个附属品，值是不做要求的。

- HashMap：无序、不重复、无索引；**（用的最多）**
- LinkedHashMap：**有序**、不重复、无索引。

**常用方法**：

- public V put(K key,V value)：添加元素
- public int size()：获取集合的大小
- public void clear()：清空集合
- public boolean isEmpty()：判断集合是否为空，为空返回true，反之
- public V get(object key)：根据键获取对应值
- public V remove(object key)：根据键删除整个元素
- public boolean containsKey(object key)：判断是否包含某个键
- public boolean containsValue(object value)：判断是否包含某个值
- public Set\<K> keySet()：获取全部键的集合
- public Collection\<V> values()：获取Map集合的全部值

**遍历方法**：

1. 键找值：先 keySet() 后 get(object key)。
2. 键值对：先 Set<Map.Entry<K, V>> endtries = map.entrySet(); 获取所有“键值对”的集合。
3. Lambda（JDK 1.8开始）：map.forEach(BiConsumer<? super K, ? super V> action); 重写accept()方法。

-------

## HashMap -- 无序、不重复 、无索引

HashMap跟HashSet的底层原理是一摸一样的，都是基于**哈希表**实现的。

**注意：Set系列集合的底层是基于Map实现的，只是Set只需要键数据，不要值数据。**

**HashMap的唯一性是由equals()和hashCode()来确定的。**

----

## LinkedHashMap -- 有序、无重复、无索引

哈希表+双链表

LinkedHashSet 是基于 LinkedHashMap 实现的 

----

## TreeMap -- 可排序、无重复、无索引

只对键排序

TreeSet 是基于 TreeMap 实现的 

----

## 集合的嵌套

**案例**：
需求：
要求在程序中记住如下省份和其对应的城市信息，记录成功后，要求可以查询出湖北省的城市信息。

- 江苏省=南京市，扬州市，苏州市，无锡市，常州市
- 湖北省=武汉市，孝感市，十堰市，宜昌市，鄂州市
- 河北省=石家庄市，唐山市，邢台市，保定市，张家口市

分析：
1. 定义一个Map集合，键用表示省份名称，值表示城市名称，注意：城市会有多个。
2. 根据“湖北省”这个键获取对应的值展示即可。

~~~java
// 1. 定义一个集合嵌套的map
Map<String, List<String>> cityMap = new HashMap<>();

// 2. 添加每个省份的城市
List<String> citis1 = new ArrayList<>();
Collections.addAll(citis1, "南京市","扬州市","苏州市","无锡市","常州市");
cityMap.put("江苏省", citis1);

List<String> citis2 = new ArrayList<>();
Collections.addAll(citis2, "武汉市","孝感市","十堰市","宜昌市","鄂州市");
cityMap.put("湖北省", citis2);

List<String> citis3 = new ArrayList<>();
Collections.addAll(citis3, "石家庄市","唐山市","邢台市","保定市","张家口市");
cityMap.put("河北省", citis3);

// 3. 输出查看
System.out.println(cityMap);
cityMap.forEach((p, c) -> System.out.println(p + "-->" + c));
~~~

-----

## Stream  --  JDK8新特性

Stream流，是JDK8的一套新增API（java.util.stream.*），**可以用来操作集合或者数组的数据**。

**优势**：**Stream流中大量的结合了lambda语法风格**，提供一个更强大、更简单的方法操作集合或者数组中的数据，**代码更简洁，可读性更好**。

**使用步骤**：

1. 获取Stream流 ---> .stream()

2. 处理Stream流 ---> 调用流水线的各种方法对数据进行处理、计算。**支持链式编程**。

3. 获得处理的结果 ---> 将处理后的结果收集到一个新集合中返回。.collect()

~~~java
list.stream().filter(操作).filter(操作).collect(获取形式);
~~~

------

## 获取Stream流

- 获取**集合**的Stream流 --- 对于Map无效

  Collection提供方法：

  default Stream\<E> stream()：获取当前集合对象的stream流

- 获取**数组**的Stream流

  1. Arrays类提供方法：

     public static \<T> Stream\<T> stream(T[] array)：获取当前数组的stream流

  2. Stream类提供的如下方法：

     public static \<T> Stream\<T> of(T...values)：获取当前接收数据的stream流

~~~java
//1、如何获取List集合的Stream流？
System.out.println("1、如何获取List集合的Stream流？");
List<String> names = new ArrayList<>();
Collections.addAll(names,"张三丰", "张无忌", "周芷若", "赵敏", "张强");
names.stream().filter(name -> name.contains("张")).forEach(System.out::println);

//2、如何获取Set集合的Stream流？
System.out.println("2、如何获取Set集合的Stream流？");
Set<String> set=new HashSet<>();
Collections.addAll(set,"刘德华", "张曼玉", "蜘蛛精", "马德", "德玛西亚");
set.stream().filter(s -> s.contains("德")).forEach(System.out::println);

//3、如何获取Map集合的Stream流？
System.out.println("3、如何获取Map集合的Stream流？");
Map<String,Double>map=new HashMap<>();
map.put("古力娜扎", 172.3);
map.put("迪丽热巴", 168.3);
map.put("马尔扎哈", 166.3);
map.put("卡尔扎巴", 168.3);

map.entrySet().stream().filter(entry -> entry.getKey().contains("扎")).forEach(entry -> System.out.println(entry.getKey() + "--->"+ entry.getValue()));

//4、如何获取数组的Stream流？
System.out.println("4、如何获取数组的Stream流？");
String[] names2={"张翠山", "东方不败", "唐大山", "独孤求败"};

// 方法1：使用Arrays中的stream()方法
System.out.println("方法1：使用Arrays中的stream()方法");
Arrays.stream(names2).filter(str -> str.contains("山")).forEach(System.out::println);

// 方法2：使用Stream中静态方法of()
System.out.println("方法2：使用Stream中静态方法of()");
Stream.of(names2).filter(str -> str.contains("山")).forEach(System.out::println);
~~~

-----

## Stream流的常见方法

- Stream\<T> filter(Predicate<? super T> predicate)：用于对流中的数据进行过滤。
- Stream\<I> sorted()：对元素进行升序排序。
- Stream\<I> sorted(Comparator<? super I> comparator)：按照指定规则排序。
- Stream\<T> limit(long maxSize)：获取前几个元素。
- Stream\<T> skip(long n)：跳过前几个元素。
- Stream\<T> distinct()：去除流中重复的元素。
- \<R> Stream\<R> map(Eunction<? super L,? extends R> mapper)：对元素进行加工，并返回对应的新流。
- static \<T> Stream\<T> concat(Stream a，Stream b)：合并a和b两个流为一个流。

~~~java
List<Double> scores = new ArrayList<>();
Collections.addAll(scores, 88.5, 100.0, 60.0, 99.0, 9.5, 99.6, 25.0);
//需求1：找出成绩大于等于60分的数据，并升序后，再输出。
System.out.println("需求1：找出成绩大于等于60分的数据，并升序后，再输出。");
scores.stream().filter(s -> s >= 60).sorted().forEach(System.out::println);

List<Student> students=new ArrayList<>();
Student s1 = new Student("蜘蛛精", 26, 172.5) ;
Student s2 = new Student("蜘蛛精", 26, 172.5);
Student s3 = new Student("紫霞", 23, 167.6);
Student s4 = new Student("白晶晶", 25, 169.0);
Student s5 = new Student("牛魔王", 35, 183.3);
Student s6 = new Student("牛夫人", 34, 168.5);
Collections.addAll(students, s1, s2, s3, s4, s5, s6);
//需求2：找出年龄大于等于23，且年龄小于等于30岁的学生，并按照年龄降序输出
System.out.println("需求2：找出年龄大于等于23，且年龄小于等于30岁的学生，并按照年龄降序输出");
students.stream().filter(student -> student.getAge() >= 23 && student.getAge() <= 30).sorted((o1, o2) -> Double.compare(o2.getAge(), o1.getAge())).forEach(System.out::println);

//需求3：取出身高最高的前3名学生，并输出。
System.out.println("需求3：取出身高最高的前3名学生，并输出。");
students.stream().sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight())).limit(3).forEach(System.out::println);

//需求4：取出身高倒数的2名学生，并输出。
System.out.println("需求4：取出身高倒数的2名学生，并输出。");
students.stream().sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight())).skip(students.size() - 2).forEach(System.out::println);

//需求5：找出身高超过168的学生叫什么名字，要求去除重复的名字，再输出。
System.out.println("需求5：找出身高超过168的学生叫什么名字，要求去除重复的名字，再输出。");
students.stream().filter(s -> s.getHeight() > 168).map(Student::getName).distinct().forEach(System.out::println);

//distinct去重复，自定义类型的对象（希望内容一样就认为重复，重写hashCode，equals）
students.stream().filter(s ->s.getHeight()>168).distinct().forEach(System.out::println);

Stream<String> st1 = Stream.of("张三", "李四");
Stream<String> st2 = Stream.of("张三2", "李四2", "王五");
Stream<String> allst = Stream.concat(st1,st2);
allst.forEach(System.out::println);
~~~











