class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def preorder(root, max_val=float('-inf')):
            if root:
                if root.val >= max_val:
                    self.res += 1
                    max_val = root.val
                preorder(root.left, max_val)
                preorder(root.right, max_val)
        
        self.res = 0
        preorder(root)
        return self.res
