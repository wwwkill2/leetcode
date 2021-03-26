class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        def build(start, end):
            if start > end:
                return None
            # find max
            max_pos = start
            for i in range(start + 1, end + 1):
                if nums[i] > nums[max_pos]:
                    max_pos = i
            root = TreeNode(nums[max_pos])
            root.left = build(start, max_pos - 1)
            root.right = build(max_pos + 1, end)
            return root
        return build(0, len(nums) - 1)
