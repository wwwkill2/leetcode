class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        // DFS
        DFS(root, 0);
        return res;
    }

    private void DFS(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        // BFS
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                max = i == 0 ? node.val : Math.max(max, node.val);
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
