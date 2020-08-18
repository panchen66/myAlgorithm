package com.panchen.myAlgorithm.bigData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Description: 设想你有一个20GB的文件，每行一个字符串，说明如何对这个文件进行排序。
 * <p>
 * 用于模拟 我设定1G文件  100M内存
 * <p>
 * 伪代码  懒，，
 * @author: chenp
 * @date: 2020/08/12 10:52
 */
public class SortBigFile {

    private static String SOURCE = "source";

    private static String DIVIDE = "divide";

    private static String RES = "res";

    private static File sourceFile;

    private static File resFile;

    private static int divideFileNum = 0;

    //分治文件缓存
    private static List<File> divideFiles = new ArrayList<>();

    //预估 一行最多20byte  1024*1024*80/20=4194304
    private static int TMP_MAX = 4194304;

    private static long[] tmp = new long[TMP_MAX];

    // 80M 20M预留jvm启动内存
    private static int SMALL_SIZE = 1024 * 1024 * 80;

    public static void main(String[] args) throws IOException {
        source();
        sort();
    }

    private static void sort() throws IOException {
        long sourceSize = sourceFile.length();
        try (RandomAccessFile sourceRaf = new RandomAccessFile(sourceFile, "r")) {

            while (sourceSize > 0) {
                tmp = new long[TMP_MAX];
                String v;
                int tmpSzie = 0;
                int index = 0;
                //双重保障内存
                while (index != TMP_MAX && tmpSzie < SMALL_SIZE) {
                    v = sourceRaf.readLine();
                    tmp[index++] = Long.valueOf(v);
                    tmpSzie += v.getBytes().length;
                }
                //分治文件排序
                sortDivide(++divideFileNum);
                sourceSize -= tmpSzie;
            }
        }
        //多路排序
        multiMergeSort();
    }


    //到这里已经是n个有序的小块数据文件了，假设有n个 已经维护内存最多80M的要求 就从每个文件取出 80/（n+1）
    private static void multiMergeSort() throws IOException {


        Map<String, RandomAccessFile> divideRafCache = new HashMap<>();
        for (File divideFile : divideFiles) {
            RandomAccessFile divideRaf = new RandomAccessFile(divideFile, "r");
            divideRafCache.put(divideFile.getName(), divideRaf);
        }

        //预估 一行最多20byte  1024*1024*80/20

        int resSize = 1024 * 1024 * 80 / 20;
        long[] res = new long[resSize];
        int i = 0;

        //进行min{min(0),min(1)}操作

        //MARK min
        String minFileName = null;

        //flag
        Boolean run = true;

        while (run) {

            for (String fileName : divideRafCache.keySet()) {

                if (i == resSize) {
                    outRes(res);
                    //reset
                    i = 0;
                    res = new long[resSize];
                }

                long v = checkContentAndGet(fileName, divideRafCache, run);

                if (0 == v) {
                    run = false;
                    break;
                }

                if (null != minFileName) {
                    //走到这里说明 需要取 这轮最小值的下一个数咯
                    long vN = Long.parseLong(divideRafCache.get(minFileName).readLine());
                    int preN = i - 1;
                    while (preN > 0) {
                        //递归swap
                        if (vN < res[preN]) {
                            swap(res, i, preN--);
                        }
                        if (preN == 0) {
                            minFileName = fileName;
                        }

                    }
                    continue;
                }

                if (i++ == 0) {
                    minFileName = fileName;
                }

                res[i] = v;
                int pre = i - 1;
                while (pre > 0) {
                    //递归swap
                    if (v < res[pre]) {
                        swap(res, i, pre--);
                    }
                    if (pre == 0) {
                        minFileName = fileName;
                    }
                }
            }
        }


    }

    private static void outRes(long[] res) throws IOException {
        resFile = new File(
            "D:" + File.separator + "test" + File.separator
                + RES);
        if (!resFile.exists()) {
            resFile.createNewFile();
        }
        try (FileWriter fw = new FileWriter(sourceFile);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for (long resLong : res) {
                bw.write(String.valueOf(resLong));
                bw.newLine();
            }
        }
    }


    // 判断分治文件是否读完了 读完了就移除
    private static long checkContentAndGet(String fileName,
        Map<String, RandomAccessFile> divideRafCache, Boolean run)
        throws IOException {
        String v = divideRafCache.get(fileName).readLine();
        if (null == v) {
            divideRafCache.remove(fileName);
            if (divideRafCache.size() == 0) {
                return 0;
            }
        }
        return Long.parseLong(v);

    }

    private static void swap(long[] arr, int source, int to) {
        long tmp = arr[source];
        arr[source] = arr[to];
        arr[to] = tmp;
    }


    private static void sortDivide(int index) throws IOException {
        //希尔排序
        shellSort(tmp);
        //生成tmp文件
        File divideFile = new File(
            "D:" + File.separator + "test" + File.separator
                + DIVIDE + index);
        divideFile.createNewFile();
        divideFiles.add(divideFile);
        try (FileWriter fw = new FileWriter(divideFile);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for (long v : tmp) {
                bw.write(String.valueOf(v));
                bw.newLine();
            }
        }
    }


    public static void shellSort(long arr[]) {
        int n = arr.length;
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                insert(arr, h, i);
            }
        }
    }

    private static void insert(long[] arr, int h, int i) {
        long temp = arr[i];
        int k;
        for (k = i - h; k > 0 && temp < arr[k]; k -= h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }

    private static void source() throws IOException {
        sourceFile = new File(
            "D:" + File.separator + "test" + File.separator
                + SOURCE);
        sourceFile.createNewFile();
        Random r = new Random();
        int size = 1024 * 1024 * 1024;
        try (FileWriter fw = new FileWriter(sourceFile);
            BufferedWriter bw = new BufferedWriter(fw)) {
            while (size > 0) {
                String v = String.valueOf(r.nextInt() * Long.MAX_VALUE);
                bw.write(v);
                bw.newLine();
                size -= v.getBytes().length + 2;
            }
        }
    }

}
