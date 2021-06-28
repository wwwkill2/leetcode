class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return
        node = head
        while node:
            new_node = Node(node.val, node.next)
            node.next = new_node
            node = new_node.next
        # set random
        node = head
        while node:
            new_node = node.next
            new_node.random = None if node.random is None else node.random.next
            node = new_node.next
        # set next
        res = head.next
        node = head
        new_node = head.next
        while node:
            node.next = new_node.next
            new_node.next = None if new_node.next is None else new_node.next.next
            node = node.next
            new_node = new_node.next
        return res
