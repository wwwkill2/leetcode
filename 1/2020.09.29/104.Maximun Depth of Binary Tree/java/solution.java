class Solution {
    public int maxDepth(TreeNode root) {
        // DFS, recursively
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        // BFS
        int depth = 0;
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.pollFirst();
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
