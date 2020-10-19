class Solution {

    Map<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        DFS(digits, 0, "");
        return res;
    }

    private void DFS(String digits, int start, String tmp) {
        // terminator
        if (start == digits.length()) {
            res.add(tmp);
            return;
        }
        // process current level
        for (char c : map.get(digits.charAt(start)).toCharArray()) {
            // drill down
            DFS(digits, start + 1, tmp + String.valueOf(c));
        }
    }
}
