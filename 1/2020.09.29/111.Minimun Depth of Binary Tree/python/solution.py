class Solution:
    def minDepth(self, root: TreeNode) -> int:
        # BFS
        depth = 0
        if not root:
            return 0
        q = [root]
        while q:
            n = len(q)
            depth += 1
            for _ in range(n):
                node = q.pop(0)
                if not node.left and not node.right:
                    return depth
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

    def minDepth(self, root: TreeNode) -> int:
        # DFS
        if not root:
            return 0
        if not root.left:
            return self.minDepth(root.right) + 1
        if not root.right:
            return self.minDepth(root.left) + 1
        return min(self.minDepth(root.left), self.minDepth(root.right)) + 1
