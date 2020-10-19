class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        def DFS(i, tmp):
            # terminator
            if len(tmp) == len(digits):
                res.append(tmp)
                return
            # process current level
            for c in d[digits[i]]:
                # drill down
                DFS(i + 1, tmp + c)
                # reset states
        
        if not digits:
            return []
        d = {}
        d['2'] = 'abc'
        d['3'] = 'def'
        d['4'] = 'ghi'
        d['5'] = 'jkl'
        d['6'] = 'mno'
        d['7'] = 'pqrs'
        d['8'] = 'tuv'
        d['9'] = 'wxyz'
        res = []
        DFS(0, '')
        return res
