class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, int start, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
