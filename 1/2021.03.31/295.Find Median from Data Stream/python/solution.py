class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.small = []
        self.large = []
        

    def addNum(self, num: int) -> None:
        if len(self.small) <= len(self.large):
            heappush(self.large, num)
            heappush(self.small, -heappop(self.large))
        else:
            heappush(self.small, -num)
            heappush(self.large, -heappop(self.small))
        

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return -self.small[0]
        elif len(self.small) < len(self.large):
            return self.large[0]
        return (self.large[0] - self.small[0]) / 2
