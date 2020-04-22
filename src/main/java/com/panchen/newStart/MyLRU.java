package com.panchen.newStart;

import java.util.HashMap;

/**
 * @Description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value) -
 * 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 思考题意 1.O(1)  想到hash 2.有个最少使用机制 那就是个顺序性  想到链表  又得变更顺序  想到 双向链表
 * <p>
 * java内实现直接 linkedHashMap ps:单链表
 * @author: chenp
 * @date: 2020/04/22 17:25
 */
public class MyLRU {

    class LRUCacheNode {

        int key;
        int value;
        LRUCacheNode prev;
        LRUCacheNode next;

    }


    class LRUCache {

        private HashMap<Integer, LRUCacheNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private LRUCacheNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new LRUCacheNode();
            tail = new LRUCacheNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            LRUCacheNode lruCacheNode = cache.get(key);
            if (null == lruCacheNode) {
                return -1;
            }
            //断链
            LRUCacheNode prev = lruCacheNode.prev;
            LRUCacheNode next = lruCacheNode.next;
            prev.next = next;
            next.prev = prev;
            //move to head
            LRUCacheNode headNext = head.next;
            head.next = lruCacheNode;
            lruCacheNode.next = headNext;
            headNext.prev = lruCacheNode;
            return lruCacheNode.value;

        }

        public void put(int key, int value) {

        }
    }

}
