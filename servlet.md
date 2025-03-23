# servlet原理

**概述**：处理客户端请求并且生成响应

**原理**：通过servlet引擎(解析请求)寻找servlet实例，做出相应处理和响应。

<img src="C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250323135357152.png" alt="image-20250323135357152" style="zoom:50%;" />

init()--在初始化执行  service()--可以进行多次使用  destroy()--结束时执行

<img src="C:\Users\eeekuu\AppData\Roaming\Typora\typora-user-images\image-20250323135326274.png" alt="image-20250323135326274" style="zoom:50%;" />