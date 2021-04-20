package com.example.redis.demo.Ccassloader;


import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassLoader);
        System.out.println("the appClassLoader : " + appClassLoader);
        System.out.printf("  ");

        System.out.println(" bootstrapClassLoader加载一下文件：");

        URL[] bootstrapUurLs = Launcher.getBootstrapClassPath().getURLs();
        Stream<URL> stream = Arrays.stream(bootstrapUurLs);
        stream.forEach(s -> System.out.println(s));

        System.out.println("extClassloader加载以下文件：");

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("appClassLoader加载以下文件：");

        System.out.println(System.getProperty("java.class.path"));

    }
}
