class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        def inorder(root):
            if root:
                inorder(root.left)
                if self.k == 1:
                    self.res = root.val
                self.k -= 1
                inorder(root.right)
        
        self.k = k
        inorder(root)
        return self.res    
