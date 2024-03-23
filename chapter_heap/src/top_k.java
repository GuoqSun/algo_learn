import utils.PrintUtil;

import java.util.PriorityQueue;
import java.util.Queue;

public class top_k {
    public static void main(String[] args) {
        int[] nums = {1, 7, 6, 3, 2};
        int k = 3;

        Queue<Integer> res = topKHeap(nums, k);
        System.out.println("最大的 " + k + " 个元素为");
        PrintUtil.printHeap(res);
    }

    public static Queue<Integer> topKHeap(int[] nums, int k) {
        // 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap;
    }
}
