import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # bucket sort
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        bucket = [[] for _ in range(len(nums)+1)]
        for key, value in d.items():
            bucket[value].append(key)
        res = []
        while len(res) < k:
            for i in range(len(bucket)-1, -1, -1):
                b = bucket[i]
                if b != []:
                    for e in b:
                        res.append(e)
                        if len(res) == k:
                            return res
        return res
