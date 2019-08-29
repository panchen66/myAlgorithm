package com.panchen.myAlgorithm;
/**
 * 给你一个装满水的 8 升满壶和两个分别是 5 升、3 升的空壶，请想个优雅的办法，使得其中一个水壶恰好装 4 升水，每一步的操作只能是倒空或倒满。
 * 
 * 广度优先遍历
 */



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KettleQuestion2 {


    class Kettle implements Cloneable {

        int maxCapacity;
        int capacity;

        public Kettle(int maxCapacity) {
            this.maxCapacity = maxCapacity;
        }


        public Kettle(int maxCapacity, int capacity) {
            this.maxCapacity = maxCapacity;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return String.valueOf(capacity);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            // TODO Auto-generated method stub
            return super.clone();
        }
    }


    @SuppressWarnings("hiding")
    class MyArrayList<Kettle> extends ArrayList<Kettle> {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        @Override
        public int hashCode() {
            StringBuilder hashCode = new StringBuilder();
            hashCode.append(get(0).toString());
            hashCode.append(get(1).toString());
            hashCode.append(get(2).toString());
            return Integer.valueOf(hashCode.toString());
        }

        public boolean equals(Object o) {
            @SuppressWarnings("unchecked")
            Kettle p = (Kettle) o;
            return this.hashCode() == p.hashCode();
        }
    }

    private static Set<MyArrayList<Kettle>> needToPour = new HashSet<MyArrayList<Kettle>>();
    private static Set<MyArrayList<Kettle>> marks = new HashSet<MyArrayList<Kettle>>();

    public static void main(String[] args) {

        MyArrayList<Kettle> first = new KettleQuestion2().new MyArrayList<Kettle>();
        first.add(new KettleQuestion2().new Kettle(8, 8));
        first.add(new KettleQuestion2().new Kettle(5));
        first.add(new KettleQuestion2().new Kettle(3));
        marks.add(first);
        needToPour.add(copyList(first));
        while (Boolean.TRUE) {
            Iterator<MyArrayList<Kettle>> it = needToPour.iterator();
            Set<MyArrayList<Kettle>> newNeedToPour = new HashSet<MyArrayList<Kettle>>();
            while (((Iterator<MyArrayList<Kettle>>) it).hasNext()) {
                MyArrayList<Kettle> kettles = copyList(it.next());
                for (int i = 0; i < kettles.size(); i++) {
                    for (int j = 0; j < kettles.size(); j++) {
                        if (i == j) {
                            continue;
                        }
                        MyArrayList<Kettle> res = pour(kettles, i, j);
                        if (null != res) {
                            check(res);
                            marks.add(res);
                            newNeedToPour.add(res);
                        }
                    }
                }
                it.remove();
            }
            needToPour.addAll(newNeedToPour);
        }

    }

    private static void check(List<Kettle> kettles) {
        for (Kettle kettle : kettles) {
            if (4 == kettle.capacity) {
                System.out.print("get :");
                System.out.print(kettles.toString());
                return;
            }
        }
    }


    private static boolean prune(List<Kettle> kettles) {
        for (List<Kettle> mark : marks) {
            int flag = 0;
            for (int i = 0; i < mark.size(); i++) {
                if (mark.get(i).capacity == kettles.get(i).capacity) {
                    flag++;
                }
            }
            if (flag == 3) {
                return true;
            }
        }
        return false;

    }

    public static MyArrayList<Kettle> pour(List<Kettle> kettles, int fromIndex, int toIndex) {
        MyArrayList<Kettle> res = copyList(kettles);
        Kettle from = res.get(fromIndex);
        Kettle to = res.get(toIndex);
        int fromTemp = from.capacity;
        int toTemp = to.capacity;
        if (from.capacity == 0 || to.capacity == to.maxCapacity) {
            return null;
        }
        if (to.capacity == to.maxCapacity) {
            return null;
        }
        if (from.capacity >= to.maxCapacity - to.capacity) {
            from.capacity -= to.maxCapacity - to.capacity;
            to.capacity = to.maxCapacity;
        } else {
            to.capacity += from.capacity;
            from.capacity = 0;
        }
        if (prune(res)) {
            // 剪枝
            // 进行还原
            from.capacity = fromTemp;
            to.capacity = toTemp;
        }
        return res;
    }

    private static MyArrayList<Kettle> copyList(List<Kettle> source) {
        MyArrayList<Kettle> res = new KettleQuestion2().new MyArrayList<KettleQuestion2.Kettle>();
        Kettle copy = null;
        if (null == source) {
            System.out.print("!");
        }
        try {
            for (Kettle kettle : source) {
                copy = (Kettle) kettle.clone();
                res.add(copy);
            }
        } catch (CloneNotSupportedException e) {
        }
        return res;
    }


}
