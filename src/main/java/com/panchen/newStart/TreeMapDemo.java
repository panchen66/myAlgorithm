package com.panchen.newStart;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description:
 * @author: chenp
 * @date: 2020/07/14 09:19
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        // creating maps
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
        SortedMap<Integer, String> treemapincl;

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

        System.out.println("Getting tail map");
        treemapincl = treemap.tailMap(7);
        System.out.println("Tail map values: " + treemapincl);
    }


}
