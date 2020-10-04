class Solution {
    public int minDepth(TreeNode root) {
        // DFS
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }

    public int minDepth(TreeNode root) {
        // BFS
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.pollFirst();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
        }
        return depth;
    }
}
