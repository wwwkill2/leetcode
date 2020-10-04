class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # DFS, recursively
        if not root:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

    def maxDepth(self, root: TreeNode) -> int:
        # BFS
        depth = 0
        if not root:
            return depth
        q = [root]
        while q != []:
            n = len(q)
            for _ in range(n):
                node = q.pop(0)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            depth += 1
        return depth
