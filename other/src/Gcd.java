public class Gcd {
    public static void main(String[] args) {
        int[] nums = {24, 60, 96};
        int result = gcd(nums);
        System.out.println(result);
    }

    // 辗转相除法
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 多个数求最大公约数
    public static int gcd(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = gcd(res, nums[i]);
            if (res == 1) {
                break;
            }
        }
        return res;
    }
}
