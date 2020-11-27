class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2') {
                    return 0;
                }
                cur = pre;
            } else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                cur += pre;
            }
            pre = tmp;
        }
        return cur;
    }
}
