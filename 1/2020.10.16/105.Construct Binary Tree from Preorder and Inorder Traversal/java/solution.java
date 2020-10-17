class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int pos = map.get(root.val);
        int pivot = pos - is;
        root.left = buildTree(preorder, ps + 1, ps + pivot, inorder, is, pivot - 1);
        root.right = buildTree(preorder, ps + 1 + pivot, pe, inorder, is + 1 + pivot, ie);
        return root;
    }
}
