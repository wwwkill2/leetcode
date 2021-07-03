class Solution:
    def romanToInt(self, s: str) -> int:
        d = {}
        d['I'] = 1
        d['V'] = 5
        d['X'] = 10
        d['L'] = 50
        d['C'] = 100
        d['D'] = 500
        d['M'] = 1000
        res = 0
        for i in range(len(s)):
            if i + 1 < len(s) and d[s[i]] < d[s[i+1]]:
                res -= d[s[i]]
            else:
                res += d[s[i]]
        return res
