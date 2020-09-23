class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        self.traversal(root, result)
        return result

    def traversal(self, root, result):
        if root:
            result.append(root.val)
            if root.children:
                for child in root.children:
                    self.traversal(child, result)
