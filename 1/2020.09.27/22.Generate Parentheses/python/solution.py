class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        self.res = []
        self.aux(0, 0, n, '')
        return self.res

    def aux(self, left, right, n, s):
        if left == n and right == n:
            self.res.append(s)
        if left < n:
            self.aux(left+1, right, n, s + '(')
        if right < left:
            self.aux(left, right+1, n, s + ')')
