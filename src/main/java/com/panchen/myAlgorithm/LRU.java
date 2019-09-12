package com.panchen.myAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

    public static void main(String[] args) {

        int size = 3;

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>((int) (size / 0.75f) + 1, 0.75f, true) {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > size;
            }
        };


        linkedHashMap.put("1", "a");
        linkedHashMap.put("2", "b");
        linkedHashMap.put("3", "c");

        linkedHashMap.put("1", "a");
        linkedHashMap.get("2");

        linkedHashMap.put("4", "d");

        for (String key : linkedHashMap.keySet()) {
            System.out.println(key);
        }


    }

}
