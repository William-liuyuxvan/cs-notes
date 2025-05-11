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

- 新浪：Redis
- 美团：Redis + Tair
- 阿里、百度：Redis + memecache

## 2、文档型数据库（bson格式-12进制 和json一样）：

- MongoDB
  - MongoDB是一个**基于分布式文件存储**的数据库，C++编写，主要用来处理大量的文档。
  - MongoDB是一个介于关系型数据库和非关系型数据库中的中间产品。MongoDB是非关系型数据库中功能最丰富、最像关系型数据库的。
- CouchDB

## 3、列存储数据库

- HBase
- 分布式文件系统

## 4、图关系数据库

- 不是存图片，而是放的关系，比如：朋友圈社交网络，广告推荐。
- Neo4j，InfoGrid



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

1. 多样的数据类型
2. 持久化
3. 事务
4. 集群
5. ...









































