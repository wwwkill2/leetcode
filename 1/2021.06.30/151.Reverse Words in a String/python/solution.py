class Solution:
    def reverseWords(self, s: str) -> str:
        res = []
        i = 0
        while i < len(s):
            if s[i] == ' ':
                i += 1
            else:
                j = i + 1
                while j < len(s):
                    if s[j] == ' ':
                        break
                    else:
                        j += 1
                res.append(s[i:j])
                i = j
        return ' '.join(res[::-1])
