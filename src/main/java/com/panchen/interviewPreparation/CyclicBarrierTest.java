package com.panchen.interviewPreparation;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @author: chenp
 * @date: 2020/03/19 16:43
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("get!"));
        for (int i = 0; i < 5; i++) {
            TestRunnable testRunnable = new TestRunnable(cyclicBarrier);
            Thread thread = new Thread(testRunnable);
            thread.start();
        }


    }

    static class TestRunnable implements Runnable {

        public TestRunnable(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            }
            System.out.println("allget!");
        }
    }

}
