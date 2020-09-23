class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(Node x, List<List<Integer>> res, int height) {
        if (x == null) {
            return;
        }
        if (res.size() == height) {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(x.val);
        if (x.children != null) {
            for (Node child : x.children) {
                levelOrder(child, res, height + 1);
            }
        }
    }
}
