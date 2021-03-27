class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        post(root);
        return res;
    }
    
    private String post(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String s = post(root.left) + "," + post(root.right) + "," + root.val;
        if (map.getOrDefault(s, 0) == 1) {
            res.add(root);
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
