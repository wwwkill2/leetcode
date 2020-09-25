from heapq import heappop, heappush
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = [1]
        i2 = i3 = i5 = 0
        while n > 1:
            u2, u3, u5 = 2*ugly[i2], 3*ugly[i3], 5*ugly[i5]
            umin = min(u2, u3, u5)
            if umin == u2:
                i2 += 1
            if umin == u3:
                i3 += 1
            if umin == u5:
                i5 += 1
            ugly.append(umin)
            n -= 1
        return ugly[-1]

    def nthUglyNumber(self, n: int) -> int:
        heap = []
        count = 0
        heappush(heap, 1)
        while True:
            res = heappop(heap)
            count += 1
            if count == n:
                return res
            while heap != [] and heap[0] == res:
                heappop(heap)
            heappush(heap, res*2)
            heappush(heap, res*3)
            heappush(heap, res*5)
