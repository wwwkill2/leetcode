class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        graph = [[] for _ in range(n)]
        for i in range(len(edges)):
            graph[edges[i][0]].append((edges[i][1], succProb[i]))
            graph[edges[i][1]].append((edges[i][0], succProb[i]))
        return self.dijkstra(start, end, graph)

    def dijkstra(self, start, end, graph):
        prob_to = [-1] * len(graph)
        prob_to[start] = 1
        heap = []
        heappush(heap, (-1, start))
        while heap:
            cur_prob, cur_node = heappop(heap)
            cur_prob = -cur_prob
            if cur_node == end:
                return cur_prob
            if cur_prob < prob_to[cur_node]:
                continue
            for next_node, weight in graph[cur_node]:
                next_prob = cur_prob * weight
                if next_prob > prob_to[next_node]:
                    prob_to[next_node] = next_prob
                    heappush(heap, (-next_prob, next_node))
        return 0
