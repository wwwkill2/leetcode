class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(new ArrayList<>(), nums);
        return res;
    }

    private void backtracking(List<Integer> tmpList, int[] nums) {
        // terminator
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        // process current level
        for (int num : nums) {
            if (!tmpList.contains(num)) {
                tmpList.add(num);
                // drill down
                backtracking(tmpList, nums);
                // reset states
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
