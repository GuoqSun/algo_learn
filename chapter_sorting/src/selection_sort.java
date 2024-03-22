import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：O(n²)、非自适应排序
 * 空间复杂度：O(1)、原地排序
 * 非稳定排序
 */
public class selection_sort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 1, 5, 2};
        selectionSort(nums);
        System.out.println("选择排序完成后 nums=" + Arrays.toString(nums));
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[k])
                    k = j;
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
}
