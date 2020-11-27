class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # bucket sort
        bucket = [0 for _ in range(1001)]
        # put arr1's elements in bucket
        for num in arr1:
            bucket[num] += 1
        res = []
        for num in arr2:
            for _ in range(bucket[num]):
                res.append(num)
                bucket[num] -= 1
        for i in range(len(bucket)):
            for _ in range(bucket[i]):
                res.append(i)
        return res
