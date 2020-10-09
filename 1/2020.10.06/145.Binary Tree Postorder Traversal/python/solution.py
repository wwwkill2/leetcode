class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        # recursively, one line
        return self.postorderTraversal(root.left) + self.postorderTraversal(root.right) + [root.val] if root else []

    def postorderTraversal(self, root: TreeNode) -> List[int]:
        # iteratively
        if not root:
            return []
        stack, res = [], []
        prev = None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if not root.right or root.right == prev:
                res.append(root.val)
                prev = root
                root = None
            else:
                stack.append(root)
                root = root.right
        return res
