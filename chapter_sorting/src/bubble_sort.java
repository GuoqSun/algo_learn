import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(n²)、自适应排序，引入flag优化后，最佳时间复杂度可达到O(n)
 * 空间复杂度：O(1)、原地排序
 * 稳定排序
 */
public class bubble_sort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 1, 5, 2};
        bubbleSort(nums);
        System.out.println("冒泡排序完成后 nums=" + Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            // 标志优化，若某次冒泡未交换任何元素，则直接跳出
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
