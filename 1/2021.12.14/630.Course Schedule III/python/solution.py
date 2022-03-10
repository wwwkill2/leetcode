class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key=lambda x : x[1])
        heap, total = [], 0
        for ti, di in courses:
            if total + ti <= di:
                total += ti
                heappush(heap, -ti)
            elif heap and -heap[0] > ti:
                total += heappop(heap)
                total += ti
                heappush(heap, -ti)
        return len(heap)
