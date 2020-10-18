class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if inorder:
            idx = inorder.index(postorder.pop())
            root = TreeNode(inorder[idx])
            root.right = self.buildTree(inorder[idx+1:], postorder)
            root.left = self.buildTree(inorder[:idx], postorder)
            return root

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def recur(low, high):
            if low > high:
                return None
            root = TreeNode(postorder.pop())
            mid = map_inorder[root.val]
            root.right = recur(mid + 1, high)
            root.left = recur(low, mid - 1)
            return root
        map_inorder = {}
        for i, val in enumerate(inorder):
            map_inorder[val] = i
        return recur(0, len(inorder) - 1)
