package com.panchen.interviewPreparation;

import java.util.ArrayList;


/**
 * @Description:
 * @author: chenp
 * @date: 2020/02/09 17:46
 */
public class TestArrayListBatchRemove {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(3);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(2);
        arrayList.removeAll(arrayList2);
    }

}
