## 数组

是相同类型数据的有序集合

### 定义方法

~~~java
int[] nums; // 首选
int nums[]; // 效果相同
~~~

### 初始化方法

~~~java
// 静态初始化：声明 + 赋值
int[] nums = {1,2,3,4,5} // "{}"大括号是数组
Men[] men = {new Men(), new Men(), new Men()}

// 动态初始化：声明 + 定义
int[] nums = new int[10];
~~~

**隐式初始化原因**：数组是引用类型，里面的元素相当于类实例变量，因此数组一旦被赋予了内存，就会按照类中实例变量的方式隐式的初始化默认值。

### 报错提醒

**ArrayIndexOutOfBoundsException**

---

## 优化冒泡排序

~~~java
public static int[] sort(int[] array) {
    int temp = 0;
    
    for (int i = 0; i < array.length - 1; i++) {
        boolean flag = false;
        for (int j = 0; j < array.length - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                flag = true;
            }
        }
        if (flag == false) {
            break;
        }
    }
    
    return array;
} 
~~~

---

## 稀疏数组

当一个数组中大部分数组值都为0，或者为同一值时，可以利用稀疏数组进行压缩数组，节约空间。利用小部分空间存放其他值，以达到压缩数组。

在稀疏数组中的索引为 0 的位置，依次存放行数、列数、有效值个数。
从稀疏数组索引 0 以后，挨个存放有效第几行、第几列、和对应的值。因此可以看出，我们在声明稀疏数组阶段为**array[][][][][有效值个数 + 1]\[3]**