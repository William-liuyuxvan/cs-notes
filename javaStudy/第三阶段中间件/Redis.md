# 课程安排

- nosql 讲解
- 阿里巴巴架构演进
- nosql数据模型
- Nosql 四大分类
- CAP
- BASE
- Redis 入门
- Redis 安装（Windows & Linux服务器）
- 五大基本数据类型
  - String
  - List
  - Set
  - Hash
  - Zset
- 三种特殊数据类型
  - geo
  - hyperloglog
  - bitmap
- Redis 配置讲解
- Redis 持久化
  - RDB
  - AOF
- Redis 事务操作
- Redis 实现订阅发布
- Redis 主从复制
- Redis 哨兵模式
- 缓存穿透及解决方案
- 缓存击穿及解决方案
- 缓存雪崩及解决方案
- 基础API 之 Jedis 详解
- SpringBoot 集成 Redis 操作
- Redis 的实践分析



# Nosql 概述

网站瓶颈：

1. 数据量太大，一个机器放不下
2. 数据索引：单表超过300万就要建立索引
3. 访问量太大 

 

NoSQL = Not Only SQL （不仅仅是SQL）泛指非关系型数据库



## 1、**NoSQL特点**：解耦

- 方便拓展（数据之间没有关系，很好扩展！）

- 大数据量高性能（Redis 一秒写8万次 读11万次。NoSQL的缓存记录级，是一种细粒度的缓存，性能会比较高。）

- 数据类型是多样性的（不需要事先设计数据库，随去随用）

- 传统 RDBMS （关系型数据库） 和NoSQL

  ~~~
  RDBMS
  - 结构化组织
  - SQL
  - 数据和关系都存储在单独的表中 row col
  - 操作语言，数据定义语言
  - 严格的一致性
  - ...
  
  NoSQL
  - 不仅仅是数据
  - 没有固定的查询语言
  - 键值对存储，列存储，文档村粗和，图形数据库（社交关系）
  - 最终一致性
  - CAP定理和BASE （异地多活）  初级架构师！
  - 高性能，高可用，高扩展
  - ...
  ~~~

  

## 2、**3V+3高**：

大数据时代的3v：主要描述问题

1. 海量volume
2. 多样variety
3. 实时velocity

大数据时代的3高：主要是对程序的要求

1. 高并发
2. 高性能
3. 高扩展



# NoSQL的四大类型

## 1、KV键值对：

- 新浪：**Redis**
- 美团：Redis + Tair
- 阿里、百度：Redis + memecache

## 2、文档型数据库（bson格式-12进制 和json一样）：

- **MongoDB**
  - MongoDB是一个**基于分布式文件存储**的数据库，C++编写，主要用来处理大量的文档。
  - MongoDB是一个介于关系型数据库和非关系型数据库中的中间产品。MongoDB是非关系型数据库中功能最丰富、最像关系型数据库的。
- CouchDB

## 3、列存储数据库

- **HBase**
- 分布式文件系统

## 4、图关系数据库

- 不是存图片，而是放的关系，比如：朋友圈社交网络，广告推荐。
- **Neo4j**，InfoGrid



四者区别：

![image-20250510172716561](Redis.assets/image-20250510172716561.png)



# Redis入门

## 1、概述

Redis（**R**emote **D**ictionary **S**erver），远程字典服务

是一个**开源**的使用ANSI [C语言](https://baike.baidu.com/item/C语言/105958?fromModule=lemma_inlink)编写、支持**网络**、可**基于内存亦可持久化**的**日志型**、**Key-Value**[数据库](https://baike.baidu.com/item/数据库/103728?fromModule=lemma_inlink)，并提供多种语言的**API**。



**作用**：

1. 内存存储、持久化，内存中是断电即失，持久化很重要（RDB、AOF）
2. 效率高，可用于高速缓存
3. 发布订阅系统（消息队列）
4. 地图信息分析
5. 计时器、计数器（浏览量）
6. ...



**特性**：

1. 多样的数据类型，键值型
2. 支持数据持久化
3. 单线程，每个命令具备原子性
4. 支持主从集群，分片集群
5. 低延迟、速度快（**基于内存**，IO多路复用，良好的编码）
6. 支持多语言客户端



## 2、命令

### 2.1 数据结构

Redis是一个key-value的数据库，key一般是String类型，不过value的类型多种多样：

![image-20250513220018475](Redis.assets/image-20250513220018475.png)



### 2.2 通用命令

通用指令是部分数据类型的，都可以使用的指令，常见的有：

- KEYS：查看符合模板的所有key，不建议在生产环境设备上使用
- DEL：删除一个指定的key
- EXISTS：判断key是否存在
- EXPIRE：给一个key设置有效期，有效期到期时该key会被自动删除
- TTL：查看一个KEY的剩余有效期

通过help[command]可以查看一个命令的具体用法，例如：

![image-20250513221101437](Redis.assets/image-20250513221101437.png)



### 2.3 String类型

String类型，也就是字符串类型，是Redis中最简单的存储类型。
其value是字符串，不过根据字符串的格式不同，又可以分为3类：

- string：普通字符串
- int：整数类型，可以做自增、自减操作
- float：浮点类型，可以做自增、自减操作

不管是哪种格式，底层都是字节数组形式存储，只不过是编码方式不同（数值类型会以二进制形式存储，字符串只能转换为对应的字节码）。**字符串类型的最大空间不能超过512m**。

![image-20250513221456987](Redis.assets/image-20250513221456987.png)



- **常见命令**：
  - SET：添加或者修改已经存在的一个String类型的键值对
  - GET：根据key获取String类型的value
  - MSET：批量添加多个String类型的键值对
  - MGET：根据多个key获取多个String类型的value
  - INCR：让一个整型的key自增1
  - INCRBY:让一个整型的key自增并指定步长，例如：incrby num 2 让num值自增2
  - INCRBYFLOAT：让一个浮点类型的数字自增并指定步长
  - SETNX：添加一个String类型的键值对，前提是这个key不存在，否则不执行
  - SETEX：添加一个String类型的键值对，并且指定有效期

**注意**：浮点数的自增必须指定步长，没有默认值。



### 2.4 Key的层级格式

Redis的key允许有多个单词形成层级结构，多个单词之间用：隔开，格式如下：

~~~sh
项目名:业务名:类型:id
~~~

这个格式并非固定，也可以根据自己的需求来删除或添加词条。

例如我们的项目名称叫heima，有user和product两种不同类型的数据，我们可以这样定义key：

- user相关的key：==heima:user:1==
- product相关的key：==heima:product:1==



如果Value是一个Java对象，例如一个User对象，则可以将对象序列化为JSON字符串后存储：

![image-20250513222833993](Redis.assets/image-20250513222833993.png)







































