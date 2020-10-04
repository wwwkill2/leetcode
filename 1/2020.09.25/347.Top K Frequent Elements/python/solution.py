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
        for i in range(len(bucket)-1, -1, -1):
            b = bucket[i]
            for num in b:
                res.append(num)
                if len(res) == k:
                    return res

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # heap
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        heap = []
        for key, value in d.items():
            if len(heap) < k:
                heapq.heappush(heap, (value, key))
            else:
                if value > heap[0][0]:
                    heapq.heappop(heap)
                    heapq.heappush(heap, (value, key))
        return [t[1] for t in heap]
