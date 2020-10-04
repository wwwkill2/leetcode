class Solution {
    public TreeNode invertTree(TreeNode root) {
        // DFS
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        // iteratively, stack
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        // BFS
        if (root == null) {
            return null;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                q.offerLast(node.left);
            }
            if (node.right != null) {
                q.offerLast(node.right);
            }
        }
        return root;
    }
}
