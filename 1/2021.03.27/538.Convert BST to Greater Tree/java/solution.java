class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.right);
            sum += root.val;
            root.val = sum;
            inorder(root.left);
        }
    }
}
