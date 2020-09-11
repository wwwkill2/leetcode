class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        l = len(nums)
        if l < 3:
            return []
        nums.sort()
        output = []
        for i in range(l-2):
            if nums[i] > 0:
                return output
            if i > 0 and nums[i] == nums[i-1]:
                continue
            target = -nums[i]
            ps, pe = i+1, l-1
            while ps < pe:
                total = nums[ps] + nums[pe]
                if total < target:
                    ps += 1
                elif total > target:
                    pe -= 1
                else:
                    output.append([-target, nums[ps], nums[pe]])
                    while ps < pe and nums[ps] == nums[ps+1]:
                        ps += 1
                    while pe > ps and nums[pe] == nums[pe-1]:
                        pe -= 1
                    ps += 1
                    pe -= 1
        return output