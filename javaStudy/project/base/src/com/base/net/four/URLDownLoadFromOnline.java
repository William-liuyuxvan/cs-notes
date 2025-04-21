package com.base.net.four;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName URLDownLoadFromOnline
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 9:09
 */
public class URLDownLoadFromOnline {
    public static void main(String[] args) throws Exception {
//        URL url = new URL("https://localhost:8080/user.pgj?username=user&password=1234");
//        /*
//        url.getProtocol(): https
//        url.getHost(): localhost
//        url.getPort(): 8080
//        url.getFile(): /user.pgj?username=user&password=1234
//        url.getPath(): /user.pgj
//        url.getQuery(): username=user&password=1234
//        url.getUserInfo(): null
//         */
//        System.out.println("url.getProtocol(): " + url.getProtocol());
//        System.out.println("url.getHost(): " + url.getHost());
//        System.out.println("url.getPort(): " + url.getPort());
//        System.out.println("url.getFile(): " + url.getFile());
//        System.out.println("url.getPath(): " + url.getPath());
//        System.out.println("url.getQuery(): " + url.getQuery());
//        System.out.println("url.getUserInfo(): " + url.getUserInfo());

        URL url = new URL("\n" +
                "https://m701.music.126.net/20250412095755/f92bfb390436a8ca83f4beddc21f772a/jdymusic/obj/wo3DlMOGwrbDjj7DisKw/59289645773/20ec/bed3/81c6/7c271d69e1e0cb64e9a0d2f68c37295c.mp3?vuutv=erg/c73+Uw7Pn9MicKoHduxKvshQPBi2qCfCciTGp9p2+F4P9+MN/ZdxyLwj7Ab/Dajk8ew+yIsL0V8WrxTF30J2dxyBufeNUcWDRoV6gqXgpXpBDZeaOYBcBNWQB9Wp77spajO3rKrbg6aqi2VqsHbatWnGpvsi1QRxcEOvizgDIkHfd85hWPv66tvsfVt3EcBvGl7ugqxENSZe4ATGeQXE23/ChdngVSsjH2RLFG+rZ3I9ARlfK5+6HwTA30fHmrUpUmu5+b38WHYNnoRbqC4ApcaZhuaWrY+/mCZCOyogBLVAjjY12Ae3Z8nJndZISPH6VcPetUE3d3U2BgyegzggkADar/nfDC2/iMrGaFJCnYe/iFfIBCKWzhVOkPur");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream is = connection.getInputStream();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("base/src/com/base/net/four/132936380-1-100024.mp3"));

        byte[] buf = new byte[1024];
        int len;

        while ((len = is.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }

        System.out.println("结束");

        bos.close();
        is.close();
        connection.disconnect();
    }
}
