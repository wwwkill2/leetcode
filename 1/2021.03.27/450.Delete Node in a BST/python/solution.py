class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        def get_min(root):
            while root.left:
                root = root.left
            return root

        if root:
            if root.val == key:
                if not root.left and not root.right:
                    return None
                if not root.left:
                    return root.right
                if not root.right:
                    return root.left
                min_node = get_min(root.right)
                root.val = min_node.val
                root.right = self.deleteNode(root.right, min_node.val)
            elif key < root.val:
                root.left = self.deleteNode(root.left, key)
            else:
                root.right = self.deleteNode(root.right, key)
            return root
