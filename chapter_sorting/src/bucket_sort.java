import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 时间复杂度：O(n+k)、非比较型排序方法、自适应排序，最差情况下O(n²)
 * 空间复杂度：O(n+k)、非原地排序
 * 稳定性取决于桶内元素的排序算法
 */
public class bucket_sort {
    public static void main(String[] args) {
        // 设输入数据为浮点数，范围为 [0, 1)
        float[] nums = {0.49f, 0.96f, 0.82f, 0.09f, 0.57f, 0.43f, 0.91f, 0.75f, 0.15f, 0.37f};
        bucketSort(nums);
        System.out.println("桶排序完成后 nums = " + Arrays.toString(nums));
    }

    public static void bucketSort(float[] nums) {
        // 初始化 k = n/2 个桶，预期向每个桶分配 2 个元素
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }
        // 1、将数组元素分配到各个桶中
        for (float num : nums) {
            int i = (int) (num * k);
            buckets.get(i).add(num);
        }
        // 2、对各个桶执行排序
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
        // 3、遍历桶合并结果
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                nums[i++] = num;
            }
        }
    }
}
