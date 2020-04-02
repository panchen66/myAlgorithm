package com.panchen.interviewPreparation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: chenp
 * @date: 2020/03/25 15:50
 */
public class UniqueOccurrences {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        //这tm会空指针？
        int i = hashMap.get(1);

        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            int count = null == hashMap.get(arr[i]) ? 0 : hashMap.get(arr[i]);
            count++;
            hashMap.put(arr[i], count);
        }
        Set<Integer> mapValuesSet = new HashSet<>(hashMap.values());
        return mapValuesSet.size() == hashMap.size() ? true : false;
    }

}
