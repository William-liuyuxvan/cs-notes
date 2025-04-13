package com.base.reflection.one;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 20:06
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获得系统类加载器的父类 --> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent(); // sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(parent);

        // 获取的扩展类加载器的父类 --> 引导类加载器
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent); // null 不可获取 是由C/c++编写的
        
        // 获得Object类的加载器
        ClassLoader objectLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(objectLoader); // null 引导类加载器
        
        // 获取当前类加载器
        ClassLoader currentClassLoader = Class.forName("com.base.reflection.one.Test05").getClassLoader();
        System.out.println(currentClassLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\charsets.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\deploy.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\access-bridge-64.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\cldrdata.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\dnsns.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\jaccess.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\jfxrt.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\localedata.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\nashorn.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunec.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunjce_provider.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunmscapi.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\sunpkcs11.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\ext\zipfs.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\javaws.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jce.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jfr.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jfxswt.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\jsse.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\management-agent.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\plugin.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\resources.jar;
            D:\soft\DevelopLanguages\java\jdk-1.8\jre\lib\rt.jar;

            E:\notes\狂神说java\project\base\target\classes;
            E:\notes\狂神说java\project\base\lib\commons-io-2.18.0.jar;

            D:\soft\DevelopmentTools\JetBrains\idea\IntelliJ IDEA 2023.3.6\lib\idea_rt.jar
         */
    }
}
