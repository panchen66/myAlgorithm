package com.panchen.myAlgorithm;

/**
 * 题目描述：
 * 
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 
 * 你允许：
 * 
 * 装满任意一个水壶 清空任意一个水壶 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 
 * 
 * 
 * 解题思路 ：
 */
public class KettleQuestion {
    
    
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 || y == 0)
            return z == x || z == y;
        int t = gcd(x, y);
        return z % t == 0 && (x + y >= z);
        
    }
    
    //求最大公约数
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        KettleQuestion KettleQuestion=new KettleQuestion();
        System.out.print(KettleQuestion.gcd(10,5));
    }
    
}
