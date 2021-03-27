class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
            if (key == root.val) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                TreeNode minNode = getMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            } else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
