class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # inorder traversal, using stack
        # according to the defination, empty tree is BST
        if not root:
            return True
        stack = []
        inorder = float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right
        return True

    def isValidBST(self, root: TreeNode) -> bool:
        # recursively
        def valid(root, lower=float('-inf'), upper=float('inf')):
            if not root:
                return True
            val = root.val
            if val <= lower or val >= upper:
                return False
            if not valid(root.left, lower, val):
                return False
            if not valid(root.right, val, upper):
                return False
            return True
        return valid(root)
