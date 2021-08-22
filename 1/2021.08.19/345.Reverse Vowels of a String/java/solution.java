class Solution {

    private Set<Character> vowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(cs[i])) {
                ++i;
            }
            while (j > i && !vowels.contains(cs[j])) {
                --j;
            }
            if (i < j) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                ++i;
                --j;
            }
        }
        return new String(cs);
    }
}
