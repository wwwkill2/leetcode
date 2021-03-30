class Solution:

    def equationsPossible(self, equations: List[str]) -> bool:
        uf = UnionFind(26)
        for s in equations:
            if s[1] == '=':
                uf.union(ord(s[0]) - ord('a'), ord(s[3]) - ord('a'))
        for s in equations:
            if s[1] == '!':
                if uf.connected(ord(s[0]) - ord('a'), ord(s[3]) - ord('a')):
                    return False
        return True


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
