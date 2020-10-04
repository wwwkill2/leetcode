class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] res = new int[n-k+1];
		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (!q.isEmpty() && q.peek() < i-k+1) {
				q.poll();
			}
			while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
				q.pollLast();
			}
			q.offer(i);
			if (i >= k - 1) {
				res[i-k+1] = nums[q.peek()];
			}
		}
		return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // dp
        if (nums == null || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = nums[0];
        rightMax[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = i % k == 0 ? nums[i] : Math.max(leftMax[i-1], nums[i]);
            int j = n - i - 1;
            rightMax[j] = (j+1) % k == 0 ? nums[j] : Math.max(rightMax[j+1], nums[j]);
        }
        int[] res = new int[n-k+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(rightMax[i], leftMax[i+k-1]);
        }
        return res;
    }
}
