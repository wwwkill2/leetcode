class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return res;
    }

    private void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            generate(left+1, right, n, s + "(");
        }
        if (right < left) {
            generate(left, right+1, n, s + ")");
        }

    }
}
