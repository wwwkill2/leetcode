class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int rootIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode recur(int low, int high, int[] inorder, int[] postorder) {
        if (low > high) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[rootIndex--]);
        int mid = map.get(root.val);
        root.right = recur(mid + 1, high, inorder, postorder);
        root.left = recur(low, mid - 1, inorder, postorder);
        return root;
    }
}
