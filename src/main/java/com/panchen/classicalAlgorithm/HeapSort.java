package com.panchen.classicalAlgorithm;

/**
 * @Description: 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * <p>
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * <p>
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 * <p>
 * 　　a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * <p>
 * 　　b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * <p>
 * 　　c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 * @author: chenp
 * @date: 2020/07/13 15:43
 */
public class HeapSort {

    // 堆排序
    public static int[] headSort(int[] arr) {
        int n = arr.length;
        //构建大顶堆
        //从非叶子节点 n/2-1开始
        for (int i = n / 2 - 1; i >= 0; i--) {
            downAdjust(arr, i, n - 1);
        }
        //进行堆排序
        for (int i = n - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性
            downAdjust(arr, 0, i - 1);
        }
        return arr;
    }

    //下沉操作
    public static void downAdjust(int[] arr, int parent, int n) {
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if (child + 1 <= n && arr[child] < arr[child + 1]) {
                child++;
            }
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (arr[child] <= temp) {
                break;
            }
            // 父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

}
