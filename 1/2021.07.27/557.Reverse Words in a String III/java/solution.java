class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length()) {
                if (cs[j] == ' ') {
                    break;
                } else {
                    j++;
                }
            }
            reverse(cs, i, j - 1);
            i = j + 1;
        }
        return new String(cs);
    }

    private void reverse(char[] cs, int start, int end) {
        while (start < end) {
            char tmp = cs[start];
            cs[start] = cs[end];
            cs[end] = tmp;
            start++;
            end--;
        }
    }
}
