class Solution:
    def connect(self, root: 'Node') -> 'Node':
        # level-order traversal
        if not root:
            return
        q = [root]
        while q:
            size = len(q)
            pre = None
            for _ in range(size):
                node = q.pop(0)
                if pre is not None:
                    pre.next = node
                pre = node
                if node.left:
                    q.append(node.left)
                    q.append(node.right)
        return root
