package com.yuxuan.test.nio.c1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestFileWalkFileTree
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/27 21:01
 */
public class TestFileWalkFileTree {
    public static void main(String[] args) throws IOException {
        AtomicInteger jarCount = new AtomicInteger();

        Files.walkFileTree(Paths.get("D:\\soft\\DevelopmentLanguages\\Java\\jre1.8.0_451"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".jar")) {
                    System.out.println(file);
                    jarCount.incrementAndGet();
                }
                return super.visitFile(file, attrs);
            }
        });

        System.out.println("end with jar counts: " + jarCount);
    }

    private static void m1() throws IOException {
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("D:\\soft\\DevelopmentLanguages\\Java\\jre1.8.0_451"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("=====>" + dir.getFileName());
                dirCount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }
        });

        System.out.println("dir count: " + dirCount.get());
        System.out.println("file count: " + fileCount);
    }
}
