class Solution:

    def __init__(self, N: int, blacklist: List[int]):
        wlen = N - len(blacklist)
        w = set()
        for i in range(wlen, N):
            w.add(i)
        for i in blacklist:
            if i in w:
                w.remove(i)
        it = iter(w)
        self.map = {}
        for i in blacklist:
            if i < wlen:
                self.map[i] = next(it)
        self.wlen = wlen
        

    def pick(self) -> int:
        k = random.randint(0, self.wlen - 1)
        return self.map.get(k, k)
