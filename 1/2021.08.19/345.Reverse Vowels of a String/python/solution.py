class Solution:
    def reverseVowels(self, s: str) -> str:
        res = []
        for c in s:
            if c in 'aeiouAEIOU':
                res.append(c)
        arr = list(s)
        for i in range(len(arr)):
            if arr[i] in 'aeiouAEIOU':
                arr[i] = res.pop()
        return ''.join(arr)
