class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length + 1; i++) {
            int height = i < heights.length ? heights[i] : 0;
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : (i-stack.peek()-1);
                maxArea = Math.max(maxArea, w*h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
