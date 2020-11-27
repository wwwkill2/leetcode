class Solution:
    def longestValidParentheses(self, s: str) -> int:
        res, q = 0, [-1]
        for i, c in enumerate(s):
            if c == '(':
                q.append(i)
            else:
                q.pop()
                if not q:
                    q.append(i)
                else:
                    res = max(res, i - q[-1])
        return res
