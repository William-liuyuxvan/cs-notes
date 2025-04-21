package com.base.collectionframework.mapImp.test;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/31 20:07
 */
/*
需求：
要求：在程序中记住如下省份和其对应的城市信息，记录成功后，要求可以查询出湖北省的城市信息。
- "江苏省"="南京市","扬州市","苏州市","无锡市","常州市"
- "湖北省"="武汉市","孝感市","十堰市","宜昌市","鄂州市"
- "河北省"="石家庄市","唐山市","邢台市","保定市","张家口市"
分析：
1. 定义一个Map集合，键用表示省份名称，值表示城市名称，注意：城市会有多个。
2. 根据“湖北省”这个键获取对应的值展示即可。
 */
public class Demo {
    public static void main(String[] args) {
        // 1. 定义一个集合嵌套的map
        Map<String, List<String>> cityMap = new HashMap<>();

        // 2. 添加每个省份的城市
        List<String> citis1 = new ArrayList<>();
        Collections.addAll(citis1, "南京市","扬州市","苏州市","无锡市","常州市");
        cityMap.put("江苏省", citis1);

        List<String> citis2 = new ArrayList<>();
        Collections.addAll(citis2, "武汉市","孝感市","十堰市","宜昌市","鄂州市");
        cityMap.put("湖北省", citis2);

        List<String> citis3 = new ArrayList<>();
        Collections.addAll(citis3, "石家庄市","唐山市","邢台市","保定市","张家口市");
        cityMap.put("河北省", citis3);

        // 3. 输出查看
        System.out.println(cityMap);
        cityMap.forEach((p, c) -> System.out.println(p + "-->" + c));
    }
}
