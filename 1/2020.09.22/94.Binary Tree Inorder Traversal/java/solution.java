class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            traversal(root.left, res);
            res.add(root.val);
            traversal(root.right, res);
        }
    }
}
