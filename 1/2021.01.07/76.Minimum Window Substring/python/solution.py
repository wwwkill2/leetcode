class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = {}
        window = {}
        for c in t:
            need[c] = need.get(c, 0) + 1
        left = right = 0
        start = valid = 0
        LEN = len(s) + 1
        while right < len(s):
            c = s[right]
            right += 1
            if c in need:
                window[c] = window.get(c, 0) + 1
                if window[c] == need[c]:
                    valid += 1
            while valid == len(need):
                if right - left < LEN:
                    start = left
                    LEN = right - left
                c = s[left]
                left += 1
                if c in need:
                    if window[c] == need[c]:
                        valid -= 1
                    window[c] -= 1
        return '' if LEN == len(s) + 1 else s[start:start+LEN]
