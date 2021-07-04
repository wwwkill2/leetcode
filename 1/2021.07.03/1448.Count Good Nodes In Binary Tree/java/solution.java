class Solution {

    private int res = 0;

    public int goodNodes(TreeNode root) {
        preorder(root, Integer.MIN_VALUE);
        return res;
    }

    private void preorder(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) {
                res++;
                max = root.val;
            }
            preorder(root.left, max);
            preorder(root.right, max);
        }
    }
}
