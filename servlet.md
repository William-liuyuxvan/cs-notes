# servlet原理

**概述**：处理客户端请求并且生成响应

**原理**：通过servlet引擎(解析请求)寻找servlet实例，做出相应处理和响应。

![imag](https://github.com/William-liuyuxvan/cs-notes/blob/main/img/servlet1.png)

init()--在初始化执行  service()--可以进行多次使用  destroy()--结束时执行

![imag](https://github.com/William-liuyuxvan/cs-notes/blob/main/img/servlet2.png)
