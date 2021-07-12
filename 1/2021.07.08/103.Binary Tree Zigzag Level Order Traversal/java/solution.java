class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = q.pollFirst();
                if (flag) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
