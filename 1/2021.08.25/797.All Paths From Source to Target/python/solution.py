class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        # DFS
        def DFS(x, tmp):
            # terminator
            if x == len(graph) - 1:
                res.append(tmp[:])
                return
            for y in graph[x]:
                tmp.append(y)
                DFS(y, tmp)
                tmp.pop()
        
        res = []
        DFS(0, [0])
        return res
