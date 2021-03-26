class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxPos = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxPos]);
        root.left = build(nums, start, maxPos - 1);
        root.right = build(nums, maxPos + 1, end);
        return root;
    }
}
