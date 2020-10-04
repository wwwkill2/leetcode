class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        self.traversal(root, res)
        return res

    def traversal(self, root, res):
        if root:
            if root.children:
                for child in root.children:
                    self.traversal(child, res)
            res.append(root.val)
