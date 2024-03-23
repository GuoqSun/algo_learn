import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：O(n log n)、非自适应排序
 * 空间复杂度：O(n)、非原地排序，借助辅助数组
 * 稳定排序
 */
public class merge_sort {
    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 6, 0, 1, 5, 4};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("归并排序完成后 nums = " + Arrays.toString(nums));
    }

    // 合并左右数组
    static void merge(int[] nums, int left, int mid, int right) {
        // 创建临时数组，用于存放合并后的结果
        int[] tmp = new int[right - left + 1];
        // 初始化左右数组起始索引
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }

    static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
}
