class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        def swap(l, r):
            while l < r:
                arr[l], arr[r] = arr[r], arr[l]
                l += 1
                r -= 1
        arr = list(s)
        n = len(s)
        i = 0
        while i < n:
            swap(i, min(i+k-1, n-1))
            i += k * 2
        return ''.join(arr)
