import heapq
class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        if k == 0:
            return []
        heap = []
        for i in range(k):
            heapq.heappush(heap, -arr[i])
        for i in range(k, len(arr)):
            if -arr[i] > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, -arr[i])
        return [-i for i in heap]

    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        return sorted(arr)[:k]
