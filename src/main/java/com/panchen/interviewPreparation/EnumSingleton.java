package com.panchen.interviewPreparation;

/**
 * @Description: 因为枚举不能进行反射
 * @author: chenp
 * @date: 2020/03/31 10:11
 */
public class EnumSingleton {

    private enum MyEnumSingleton {

        INSTANCE;

        public void doSomething() {
            System.out.println("doSomething");
        }


    }

}