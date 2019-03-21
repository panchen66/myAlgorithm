package com.panchen.myAlgorithm;

/**
 * 小明买了一箱鸡蛋，可以一天吃一个，也可以一天吃2个，总共有多少种吃法
 * 
 * @author pc
 *
 */
public class EatEgg {

    private static int getEatEggWay(int eggSum) {
        int result = 0;
        if (1 == eggSum) {
            return 1;
        }
        if (2 == eggSum) {
            return 2;
        }
        if (0 < eggSum) {
            result += getEatEggWay(--eggSum);
            result += getEatEggWay(--eggSum);
        }
        return result;

    }
    
    
    //动态规划版
    private static int getEatEggWay() {
        return 0;}

    public static void main(String[] args) {
        System.out.print(getEatEggWay(10));
    }
}
