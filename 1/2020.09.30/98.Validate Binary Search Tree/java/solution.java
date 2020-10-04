class Solution {
    public boolean isValidBST(TreeNode root) {
        // recursively
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }


    public boolean isValidBST(TreeNode root) {
        // inorder
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
