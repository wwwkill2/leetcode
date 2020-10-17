class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # DFS
        def DFS(level, root):
            if root:
                if level == len(res):
                    res.append([])
                res[level].append(root.val)
                if root.left:
                    DFS(level+1, root.left)
                if root.right:
                    DFS(level+1, root.right)
        res = []
        DFS(0, root)
        return res

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # BFS
        if not root:
            return []
        res, q = [], [root]
        while q:
            r, size = [], len(q)
            for _ in range(size):
                node = q.pop(0)
                r.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(r)
        return res
