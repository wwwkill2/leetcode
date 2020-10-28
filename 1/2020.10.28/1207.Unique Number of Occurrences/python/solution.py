class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        d = {}
        for num in arr:
            d[num] = d.get(num, 0) + 1
        return len(d.keys()) == len(set(d.values()))
