class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (n > 1) {
            int u2 = 2 * ugly.get(i2);
            int u3 = 3 * ugly.get(i3);
            int u5 = 5 * ugly.get(i5);
            int umin = Math.min(u2, Math.min(u3, u5));
            if (umin == u2) {
                i2++;
            }
            if (umin == u3) {
                i3++;
            }
            if (umin == u5) {
                i5++;
            }
            ugly.add(umin);
            n--;
        }
        return ugly.get(ugly.size() - 1);
    }
}
