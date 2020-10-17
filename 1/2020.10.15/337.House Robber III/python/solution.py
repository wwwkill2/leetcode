class Solution:
    def rob(self, root: TreeNode) -> int:
        def _rob(root):
            if not root:
                return 0, 0
            left = _rob(root.left)
            right = _rob(root.right)
            cur_no = max(left[0], left[1]) + max(right[0], right[1])
            cur_yes = left[0] + right[0] + root.val
            return cur_no, cur_yes
        res = _rob(root)
        return max(res[0], res[1])
