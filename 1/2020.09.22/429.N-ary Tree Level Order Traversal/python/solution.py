class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        q, res = [root], []
        while any(q):
            res.append([node.val for node in q])
            q = [child for node in q for child in node.children if child]
        return res
