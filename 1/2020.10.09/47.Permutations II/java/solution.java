class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        backtracking(nums, vis, new ArrayList<>());
        return res;
    }
    
    private void backtracking(int[] nums, boolean[] vis, List<Integer> tmp) {
        // terminator
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // process current level
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])) {
                continue;
            }
            tmp.add(nums[i]);
            vis[i] = true;
            // drill down
            backtracking(nums, vis, tmp);
            // reset states
            tmp.remove(tmp.size()-1);
            vis[i] = false;
        }
    }
}
