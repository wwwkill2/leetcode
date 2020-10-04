class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # DFS, recursively
        if not root:
            return None
        left = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(left)
        return root

    def invertTree(self, root: TreeNode) -> TreeNode:
        # DFS, iteratively
        if not root:
            return None
        stack = [root]
        while stack != []:
            node = stack.pop()
            node.left, node.right = node.right, node.left
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return root

    def invertTree(self, root: TreeNode) -> TreeNode:
        # BFS
        if not root:
            return None
        q = [root]
        while q != []:
            node = q.pop(0)
            node.left, node.right = node.right, node.left
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
        return root
