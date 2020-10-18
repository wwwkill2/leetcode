class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode recur(int low, int high, int[] preorder, int[] inorder) {
        if (low > high) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex++]);
        int mid = map.get(root.val);
        root.left = recur(low, mid - 1, preorder, inorder);
        root.right = recur(mid + 1, high, preorder, inorder);
        return root;
    }
}
