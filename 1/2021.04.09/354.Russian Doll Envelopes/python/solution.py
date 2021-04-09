class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x : (x[0], -x[1]))
        dp = []
        for envelope in envelopes:
            num = envelope[1]
            if not dp or num > dp[-1]:
                dp.append(num)
            else:
                left, right = 0, len(dp) - 1
                while left <= right:
                    mid = left + (right - left) // 2
                    if dp[mid] < num:
                        left = mid + 1
                    elif dp[mid] > num:
                        right = mid - 1
                    else:
                        right = mid - 1
                dp[left] = num
        return len(dp)
