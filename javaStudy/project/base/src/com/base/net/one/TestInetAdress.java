package com.base.net.one;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @ClassName TestInetAdress
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/10 11:14
 */
public class TestInetAdress {
    public static void main(String[] args) {
        try {
            InetAddress address1 = InetAddress.getByName("127.0.0.1");
            InetAddress address2 = InetAddress.getByName("localhost");
            InetAddress address3 = InetAddress.getLocalHost();

            System.out.println(address1);
            System.out.println(address2);
            System.out.println(address3);
            System.out.println(address3.getHostName());

            InetAddress address4 = InetAddress.getByName("www.google.com");

            System.out.println("www.google.com: " + address4);
            System.out.println("getAddress(): " + Arrays.toString(address4.getAddress()));
            System.out.println("getHostAddress(): " + address4.getHostAddress());
            System.out.println("getCanonicalHostName(): " + address4.getCanonicalHostName());
            System.out.println("getHostName(): " + address4.getHostName());
            System.out.println("getClass(): " + address4.getClass());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
