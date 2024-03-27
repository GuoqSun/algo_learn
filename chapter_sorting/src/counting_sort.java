import java.util.Arrays;

/**
 * 计数排序
 * 时间复杂度：O(n+m)、非比较型排序方法、时间复杂度趋于O(n)
 * 空间复杂度：O(n+k)、非原地排序
 * 稳定排序（倒序遍历nums）
 */
public class counting_sort {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2, 0, 4, 0, 2, 2, 4};
        countingSortNaive(nums);
        System.out.println("计数排序（无法排序对象）完成后 nums = " + Arrays.toString(nums));

        int[] nums1 = {1, 0, 1, 2, 0, 4, 0, 2, 2, 4};
        countingSort(nums1);
        System.out.println("计数排序完成后 nums1 = " + Arrays.toString(nums1));
    }

    // 简单实现，无法排序对象
    static void countingSortNaive(int[] nums) {
        // 1. 统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        // 2. 统计各数字的出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }
        // 3. 遍历 counter ，将各元素填入原数组 nums
        int i = 0;
        for (int j = 0; j < m + 1; j++) {
            for (int k = 0; k < counter[j]; k++) {
                nums[i++] = j;
            }
        }
    }

    // 完整实现，可排序对象，并且是稳定排序
    static void countingSort(int[] nums) {
        // 1. 统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        // 2. 统计各数字的出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }
        // 3. 求 counter 的前缀和，将“出现次数”转换为“尾索引”
        // 即 counter[num]-1 是 num 在 res 中最后一次出现的索引
        for (int i = 1; i < m + 1; i++) {
            counter[i] += counter[i - 1];
        }
        // 4. 倒序遍历 nums ，将各元素填入结果数组 res
        // 初始化数组 res 用于记录结果
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            res[counter[num] - 1] = num;
            counter[num]--;
        }
        System.arraycopy(res, 0, nums, 0, n);
    }
}
