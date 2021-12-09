class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = [[] for _ in range(n + 1)]
        for edge in times:
            graph[edge[0]].append((edge[1], edge[2]))
        dist_to = self.dijkstra(k, graph)
        res = 0
        for i in range(1, len(dist_to)):
            if dist_to[i] == float('inf'):
                return -1
            res = max(res, dist_to[i])
        return res

    def dijkstra(self, start, graph):
        dist_to = [float('inf')] * len(graph)
        dist_to[start] = 0
        heap = []
        heappush(heap, (0, start))
        while heap:
            cur_dist, cur_node = heappop(heap)
            if cur_dist > dist_to[cur_node]:
                continue
            for nex_node, weight in graph[cur_node]:
                nex_dist = cur_dist + weight
                if nex_dist < dist_to[nex_node]:
                    dist_to[nex_node] = nex_dist
                    heappush(heap, (nex_dist, nex_node))
        return dist_to
