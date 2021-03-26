class Solution {
    public Node connect(Node root) {
        if (root != null) {
            connectTwo(root.left, root.right);
        }
        return root;
    }

    private void connectTwo(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return;
        }
        n1.next = n2;
        connectTwo(n1.left, n1.right);
        connectTwo(n1.right, n2.left);
        connectTwo(n2.left, n2.right);
    }
}
