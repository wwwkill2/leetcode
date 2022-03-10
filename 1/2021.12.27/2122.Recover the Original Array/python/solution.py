from collections import defaultdict
class Solution:
    def recoverArray(self, nums):
        n = len(nums)
        nums.sort()
        for i in range(1, n):
            if nums[i] == nums[0] or (nums[i] - nums[0]) % 2 != 0:
                continue
            used = [False] * n
            used[0] = used[i] = True
            k = (nums[i] - nums[0]) // 2
            ans = [nums[0] + k]

            left, right = 0, i
            for j in range(1, n // 2):
                while used[left]:
                    left += 1
                while right < n and (used[right] or nums[right] - nums[left] != k * 2):
                    right += 1
                if right == n:
                    break
                ans.append(nums[left] + k)
                used[left] = used[right] = True

            if len(ans) == n // 2:
                return ans



def main():
    so = Solution()
    nums = [2, 10, 6, 4, 8, 12]
    print(so.recoverArray(nums))


if __name__ == '__main__':
    main()


