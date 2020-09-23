class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    traversal(child, res);
                }
            }
        }
    }
}
