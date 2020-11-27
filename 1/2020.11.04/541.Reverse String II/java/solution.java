class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int i = 0;
        while (i < n) {
            swap(ch, i, Math.min(i+k-1, n-1));
            i += k*2;
        }
        return new String(ch);
    }
    
    private void swap(char[] ch, int start, int end) {
        while (start < end) {
            char tmp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = tmp;
        }
    }
}
