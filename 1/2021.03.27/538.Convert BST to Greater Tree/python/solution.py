class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
        def inorder(root):
            if root:
                inorder(root.right)
                root.val += self.sum
                self.sum = root.val
                inorder(root.left)
        
        self.sum = 0
        inorder(root)
        return root
