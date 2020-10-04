class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        generate(1, new ArrayList<>(), n, k);
        return res;
    }

    private void generate(int start, List<Integer> tmpList, int n, int k) {
        // terminator
        if (k == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            // process current level
            tmpList.add(i);
            // drill down
            generate(i+1, tmpList, n, k - 1);
            // reset states
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
