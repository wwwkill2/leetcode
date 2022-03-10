class Solution(object):
    def maximumInvitations(self, g):
        """
        :type g: List[int]
        :rtype: int
        """
        n = len(g)
        deg = [0] * n
        for w in g:
            deg[w] += 1
        q = deque(i for i, d in enumerate(deg) if d == 0)
        max_depth = [0] * n
        while q:
            v = q.popleft()
            max_depth[v] += 1
            w = g[v]
            max_depth[w] = max(max_depth[w], max_depth[v])
            deg[w] -= 1
            if deg[w] == 0:
                q.append(w)

        max_ring_size, sum_chain_size = 0, 0
        for i, d in enumerate(deg):
            if d == 0:
                continue
            deg[i] = 0
            ring_size = 1
            v = g[i]
            while v != i:
                ring_size += 1
                deg[v] = 0
                v = g[v]
            if ring_size == 2:
                sum_chain_size += max_depth[i] + max_depth[g[i]] + 2
            else:
                max_ring_size = max(max_ring_size, ring_size)
        return max(max_ring_size, sum_chain_size)
