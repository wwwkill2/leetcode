class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.traversal(root, res)
        return res
    
    def traversal(self, root, result):
        if root:
            self.traversal(root.left, result)
            result.append(root.val)
            self.traversal(root.right, result)
