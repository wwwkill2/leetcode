class Solution {
    
    int cur = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    
    private void inorder(TreeNode root, int k) {
        if (root != null) {
            inorder(root.left, k);
            cur++;
            if (cur == k) {
                res = root.val;
                return;
            }
            inorder(root.right, k);
        }
    } 
}
