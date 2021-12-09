class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        arr = []
        for event in events:
            arr.append((event[0], 0, event[2]))
            arr.append((event[1], 1, event[2]))
        arr.sort()
        res = best = 0
        for ts, op, val in arr:
            if op == 0:
                res = max(res, best + val)
            else:
                best = max(best, val)
        return res
