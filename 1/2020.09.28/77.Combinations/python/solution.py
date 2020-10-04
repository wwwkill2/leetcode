class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def _generate(start, tmp, k):
            # terminator
            if k == 0:
                res.append(tmp[:])
                return
            for i in range(start, n - k + 2):
                # process current level
                tmp.append(i)
                # drill down
                _generate(i+1, tmp, k-1)
                # reset states
                tmp.pop()
        
        res = []
        _generate(1, [], k)
        return res
