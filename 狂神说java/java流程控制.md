## scanner

属于io流中的所有类使用完了都要关闭（.close()），节约资源

基本语法：

~~~java
Scanner s = new Scanner(System.in);
~~~

通过Scanner类的next()与nextLine()方法获取输入的字符串，在读取前我们一般需要用hasNext()与hasNextLine()判断是否还有输入的数据。

---

 ## 增强for循环

~~~java
for (声明语句 : 表达式) {}
~~~

---

## 与goto关键词同用法的带有标签的continue和break

~~~java
outer:for（int i=101;i<150;i++）{
    for（intj=2；j<i/2；j++）{
        if（i%j==θ){
        	continue outer;
        }
    System.out.print(i+"");
    }
}
~~~



