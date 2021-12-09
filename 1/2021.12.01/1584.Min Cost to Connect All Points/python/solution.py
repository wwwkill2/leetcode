class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        if n < 2:
            return 0
        arr = []
        for i in range(n - 1):
            p1 = points[i]
            for j in range(1, n):
                p2 = points[j]
                arr.append((i, j, abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])))
        arr.sort(key=lambda x: x[2])
        mst = 0
        uf = UF(n)
        for i, j, weight in arr:
            if uf.is_connected(i, j):
                continue
            mst += weight
            uf.union(i, j)
            if uf.count == 1:
                return mst



class UF:

    def __init__(self, count) -> None:
        self.count = count
        self.parent = [i for i in range(count)]
        self.size = [1] * count
    

    def union(self, p, q):
        root_p, root_q = self._find(p), self._find(q)
        if root_p == root_q:
            return
        if self.size[root_p] > self.size[root_q]:
            self.parent[root_q] = root_p
            self.size[root_p] += self.size[root_q]
        else:
            self.parent[root_p] = root_q
            self.size[root_q] += self.size[root_p]
        self.count -= 1


    def is_connected(self, p, q):
        root_p, root_q = self._find(p), self._find(q)
        return root_p == root_q

    def _find(self, x):
        while self.parent[x] != x:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x
