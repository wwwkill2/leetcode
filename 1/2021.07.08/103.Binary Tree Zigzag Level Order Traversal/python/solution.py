class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        # DFS
        def DFS(root, level):
            if root:
                if len(res) == level:
                    res.append([])
                if level % 2 == 0:
                    res[level].append(root.val)
                else:
                    res[level].insert(0, root.val)
                DFS(root.left, level + 1)
                DFS(root.right, level + 1)
        
        res = []
        DFS(root, 0)
        return res
