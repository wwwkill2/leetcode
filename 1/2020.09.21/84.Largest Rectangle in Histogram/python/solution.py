class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(0)
        stack = [-1]
        max_area = 0
        for i, height in enumerate(heights):
            while height < heights[stack[-1]]:
                h = heights[stack.pop()]
                max_area = max(max_area, (i-stack[-1]-1) * h)
            stack.append(i)
        heights.pop()
        return max_area
