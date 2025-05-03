package com.yuxuan;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @ClassName LogTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/26 15:28
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog(){
        logger.info(LocalDateTime.now() + " : 开始计算...");

        int sum = 0;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
        for (int num : nums) {
            sum += num;
        }

        logger.warn("计算结果为: "+sum);
        logger.info(LocalDateTime.now() + "结束计算...");
    }

}