class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self.traversal(root, result)
        return result

    def traversal(self, root, result):
        if root:
            result.append(root.val)
            self.traversal(root.left, result)
            self.traversal(root.right, result)
