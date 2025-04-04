package com.base.io.io.conversion_flow;

import java.io.*;

/**
 * @ClassName Demo2
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 15:04 阿道夫
 */
public class Demo2 {
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("base\\src\\com\\base\\io\\io\\conversion_flow\\testOut.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
                BufferedWriter bw = new BufferedWriter(osw)){
            bw.write("s");
            bw.newLine();
            bw.write("liu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
