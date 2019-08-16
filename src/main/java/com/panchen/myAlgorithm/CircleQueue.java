package com.panchen.myAlgorithm;

/**
 * 
 * 顺序队列由于挪动头尾指针 可能导致有大量空位置 后续有新元素进来会有溢出现象
 * 
 * 环形队列 可以解决这个问题 其实就是少用一个元素的空间，约定入队前测试尾指针在循环下加 1 后是否等于头指针，若相等则认为队满
 * 
 * @author: chenp
 *
 */
public class CircleQueue {

    private int front;
    private int end;
    private int elements;
    private long[] queue;

    public CircleQueue() {
        queue = new long[5];
        front = -1;
        end = -1;
    }

    public CircleQueue(int length) {
        queue = new long[length];
        front = -1;
        end = -1;
    }


    public void add(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            front = 0;
        }
        if ((end == queue.length - 1)) {
            end = -1;
        }
        queue[++end] = value;
        elements++;
    }

    public void delete() {
        if ((front == queue.length)) {
            front = -1;
        }
        queue[front] = -1;
        front++;
        elements--;
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == -1) {
                System.out.print("X" + " ");
            } else {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }

    public long getFront() {
        if (isEmpty()) {
            return 0;
        }
        return queue[front];
    }

    public long getEnd() {
        if (isEmpty()) {
            return -1;
        }
        return queue[end];
    }

    public boolean isFull() {
        return elements == queue.length;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public int size() {
        return elements;
    }
}
