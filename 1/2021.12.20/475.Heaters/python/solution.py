class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()
        res = 0
        j = 0
        for i in range(len(houses)):
            cur = abs(houses[i] - heaters[j])
            while j < len(heaters) - 1 and abs(houses[i] - heaters[j]) >= abs(houses[i] - heaters[j + 1]):
                j += 1
                cur = min(cur, abs(houses[i] - heaters[j]))
            res = max(res, cur)
        return res
