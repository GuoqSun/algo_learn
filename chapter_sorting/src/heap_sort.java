import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度：O(n log n)、非自适应排序
 * 空间复杂度：O(1)、原地排序
 * 非稳定排序
 */
public class heap_sort {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 1, 5, 2 };
        heapSort(nums);
        System.out.println("堆排序完成后 nums = " + Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {
        // 建大顶堆操作
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        // 从堆中提取最大元素
        for (int i = nums.length - 1; i >= 0; i--) {
            // 交换根节点和最右叶子节点
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 以根节点为起点，从顶至底进行堆化
            siftDown(nums, i, 0);
        }
    }

    // 堆长度为n，从节点i开始，从顶至底堆化
    public static void siftDown(int[] nums, int n, int i) {
        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int max = i;
            if (l < n && nums[l] > nums[max]) max = l;
            if (r < n && nums[r] > nums[max]) max = r;
            if (max == i) break;
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
            i = max;
        }
    }
}
