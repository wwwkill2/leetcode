class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root:
            self.flatten(root.left)
            self.flatten(root.right)

            left, right = root.left, root.right
            root.left = None
            root.right = left
            while root.right:
                root = root.right
            root.right = right
