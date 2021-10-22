class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        L = 10
        bin = {'A': 0, 'C': 1, 'G': 2, 'T': 3}
        n = len(s)
        if n <= L:
            return []
        res = []
        x = 0
        for ch in s[:L-1]:
            x = (x << 2) | bin[ch]
        cnt = defaultdict(int)
        # i + 10 - 1 == n - 1
        # i = n - 10
        for i in range(n - L + 1):
            x = ((x << 2) | bin[s[i + L - 1]]) & ((1 << L * 2) - 1)
            cnt[x] += 1
            if cnt[x] == 2:
                res.append(s[i:i + L])
        return res
