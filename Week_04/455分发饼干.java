class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;  // 胃口值数组索引
        int j = 0;  // 饼干尺寸值数组索引
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}