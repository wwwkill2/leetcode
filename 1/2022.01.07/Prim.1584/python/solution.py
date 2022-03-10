class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        graph = [[] for _ in range(n)]
        for i in range(n - 1):
            p1 = points[i]
            for j in range(i + 1, n):
                p2 = points[j]
                graph[i].append((abs(p1[0] - p2[0]) + abs(p1[1] - p2[1]), i, j))
                graph[j].append((abs(p1[0] - p2[0]) + abs(p1[1] - p2[1]), j, i))
        in_mst = [False] * n
        heap = []

        def cut(s):
            for edge in graph[s]:
                to = edge[2]
                if in_mst[to]:
                    continue
                heappush(heap, edge)
        
        in_mst[0] = True
        cut(0)
        weight_sum = 0
        i = 1
        while i < n:
            edge = heappop(heap)
            to = edge[2]
            weight = edge[0]
            if in_mst[to]:
                continue
            weight_sum += weight
            in_mst[to] = True
            i += 1
            cut(to)
        return weight_sum
