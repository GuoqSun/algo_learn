public class KMP {
    public static void main(String[] args) {
        String s1 = "aabaabaafa";
        String s2 = "aabaaf";
        int res = strStr(s1, s2);
        System.out.println(res);
    }


    /**
     * 给定一个 s1 字符串和一个 s2 字符串，在 s1 字符串中找出 s2 字符串出现的第一个位置 (从0开始)。如果不存在，则返回-1。
     *
     * @param s1 文本串
     * @param s2 模式串
     * @return 匹配位置
     */
    public static int strStr(String s1, String s2) {
        if (s2.isEmpty()) return 0;
        int[] next = new int[s2.length()];
        getNext(next, s2);

        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            while (j > 0 && s2.charAt(j) != s1.charAt(i)) {
                j = next[j - 1];
            }
            if (s2.charAt(j) == s1.charAt(i)) {
                j++;
            }
            if (j == s2.length()) {
                return i - s2.length() + 1;
            }
        }
        return -1;
    }

    public static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                // 前后缀不相同了
                j = next[j - 1];
            }
            // 找到相同的前后缀
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            // 将j（前缀的长度）赋给next[i]
            next[i] = j;
        }
    }
}
