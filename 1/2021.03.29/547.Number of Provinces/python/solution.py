class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        uf = UnionFind(len(M))
        for i in range(len(M)):
            for j in range(len(M)):
                if M[i][j] == 1:
                    uf.union(i, j)
        return uf.count

class UnionFind:

    def __init__(self, n) -> None:
        self.count = n
        self.parent = [i for i in range(n)]
    
    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x
    
    def union(self, p, q):
        root_p = self.find(p)
        root_q = self.find(q)
        if root_p == root_q:
            return
        self.parent[root_p] = root_q
        self.count -= 1
    
    def connected(self, p, q):
        root_p = self.find(p)
        root_q = self.find(q)
        return root_p == root_q
