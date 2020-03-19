package com.panchen.interviewPreparation;

import java.util.concurrent.Semaphore;

/**
 * @Description: study semaphore
 * @author: chenp
 * @date: 2020/03/18 15:48
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
