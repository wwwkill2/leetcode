class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # BFS
        if not root:
            return []
        res, q = [], [root]
        while q:
            size = len(q)
            level_max = float('-inf')
            for _ in range(size):
                node = q.pop(0)
                if node.val > level_max:
                    level_max = node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(level_max)
        return res

    def largestValues(self, root: TreeNode) -> List[int]:
        # DFS
        def traversal(root, level):
            if not root:
                return
            if len(res) == level:
                res.append(float('-inf'))
            res[level] = max(res[level], root.val)
            traversal(root.left, level+1)
            traversal(root.right, level+1)
        res = []
        traversal(root, 0)
        return res

    # BFS from StefanPochmann
        maxes = []
        row = [root]
        while any(row):
            maxes.append(max(node.val for node in row))
            row = [kid for node in row for kid in (node.left, node.right) if kid]
        return maxes
