class Solution {

    private Map<Node, Node> visited = new HashMap<>();

    private Node getCloneNode(Node head) {
        if (head == null) {
            return null;
        }
        if (!visited.containsKey(head)) {
            visited.put(head, new Node(head.val));
        }
        return visited.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(head.val);
        visited.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.random = getCloneNode(oldNode.random);
            newNode.next = getCloneNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(head);
    }
}
