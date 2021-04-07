class Solution:
    def countNodes(self, root: TreeNode) -> int:
        l = r = root
        hl = hr = 0
        while l:
            l = l.left
            hl += 1
        while r:
            r = r.right
            hr += 1
        if hl == hr:
            return pow(2, hl) - 1
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
