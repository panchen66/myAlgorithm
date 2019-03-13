package com.panchen.myAlgorithm;

import java.nio.charset.Charset;

import com.google.common.hash.Funnels;

/**
 * guava的bloomFilter 在hash后的 array填充前 对数值的操作 以及 初始化的默认数组大小和函数计算数 有较大的优化
 * 
 * @author pc
 *
 */
public class BloomFilter {

    public static void main(String[] args) {
        com.google.common.hash.BloomFilter<String> b =
                com.google.common.hash.BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000, 0.000001);
        b.put("121");
        b.put("122");
        b.put("123");
        System.out.println(b.mightContain("121"));
    }
}
