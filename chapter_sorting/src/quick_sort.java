import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 0, 3, 5};
        QuickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序完成后 nums = " + Arrays.toString(nums));

        int[] nums1 = {2, 4, 1, 0, 3, 5};
        QuickSortMedian.quickSort(nums1, 0, nums1.length - 1);
        System.out.println("快速排序（中位基准数优化）完成后 nums1 = " + Arrays.toString(nums1));

        int[] nums2 = { 2, 4, 1, 0, 3, 5 };
        QuickSortTailCall.quickSort(nums2, 0, nums2.length - 1);
        System.out.println("快速排序（尾递归优化）完成后 nums2 = " + Arrays.toString(nums2));
    }
}

/**
 * 快速排序类（原始）
 * 时间复杂度：O(n log n)、自适应排序，最差时间复杂度可达到O(n²)
 * 空间复杂度：O(n)递归栈帧空间、原地排序
 * 非稳定排序
 */
class QuickSort {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[j] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
}

/**
 * 快速排序类（中位基准数优化）
 */
class QuickSortMedian {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 选取三个候选元素的中位数
    static int medianThree(int[] nums, int left, int mid, int right) {
        int l = nums[left], m = nums[mid], r = nums[right];
        if ((l <= m && m <= r) || (r <= m && m <= l)) {
            return mid;
        }
        if ((m <= l && l <= r) || (r <= l && l <= m)) {
            return left;
        }
        return right;
    }

    static int partition(int[] nums, int left, int right) {
        int med = medianThree(nums, left, (left + right) / 2, right);
        swap(nums, med, left);
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[j] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
}

class QuickSortTailCall {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[j] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    static void quickSort(int[] nums, int left, int right) {
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot - left < right - pivot) {
                quickSort(nums, left, pivot - 1);
                left = pivot + 1;
            } else {
                quickSort(nums, pivot + 1, right);
                right = pivot - 1;
            }
        }
    }
}