package com.yuxuan.utils;

/**
 * @ClassName CurrentHolder
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 15:49
 */
public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrentId(Integer employeeId){
        CURRENT_LOCAL.set(employeeId);
    }

    public static Integer getCurrentId(){
        return CURRENT_LOCAL.get();
    }

    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}
