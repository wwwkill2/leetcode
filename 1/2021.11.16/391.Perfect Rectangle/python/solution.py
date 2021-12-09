class Solution:
    def isRectangleCover(self, rectangles: List[List[int]]) -> bool:
        total_area = 0
        left = down = float('inf')
        right = up = float('-inf')
        s = set()
        for rectangle in rectangles:
            left = min(left, rectangle[0])
            down = min(down, rectangle[1])
            right = max(right, rectangle[2])
            up = max(up, rectangle[3])
            total_area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1])
            p1, p2, p3, p4 = (rectangle[0], rectangle[1]), (rectangle[2], rectangle[3]), (rectangle[0], rectangle[3]), (rectangle[2], rectangle[1])
            for p in (p1, p2, p3, p4):
                if p not in s:
                    s.add(p)
                else:
                    s.remove(p)
        return len(s) == 4 and (left, down) in s and (left, up) in s and (right, down) in s and (right, up) in s and total_area == (right - left) * (up - down)
