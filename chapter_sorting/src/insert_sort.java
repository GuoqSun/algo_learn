import java.util.Arrays;

/**
 * 插入排序（内置排序函数采用，数据量较小时）
 * 时间复杂度：O(n²)、自适应排序，最佳时间复杂度可达到O(n)，遇到有序数据时，插入操作会提前终止
 * 空间复杂度：O(1)、原地排序
 * 稳定排序
 */
public class insert_sort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 1, 5, 2};
        insertSort(nums);
        System.out.println("插入排序完成后 nums=" + Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }
}
