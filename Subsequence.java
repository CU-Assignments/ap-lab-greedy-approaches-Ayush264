class Solution {
    public int minOperations(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(a[i], i);
        }
        int[] c = new int[m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            b[i] = map.getOrDefault(b[i], -1);
            if (b[i] >= 0) {
                if (k == 0 || b[i] > c[k - 1]) {
                    c[k++] = b[i];
                }
                else {
                    int j = Arrays.binarySearch(c, 0, k, b[i]);
                    if (j < 0) j = - (j + 1);
                    c[j] = b[i];
                }
            }
        }
        return m - k;
    }
}
