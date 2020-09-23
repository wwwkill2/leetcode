class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.min = []

    def push(self, x: int) -> None:
        self.data.append(x)
        if not self.min or x <= self.min[-1]:
            self.min.append(x)

    def pop(self) -> None:
        x = self.data.pop()
        if x == self.min[-1]:
            self.min.pop()

    def top(self) -> int:
        return self.data[-1] 

    def getMin(self) -> int:
        return self.min[-1]

# only use one stack
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.MIN = None


    def push(self, x: int) -> None:
        if self.MIN is None or x <= self.MIN:
            self.data.append(self.MIN)
            self.MIN = x
        self.data.append(x)


    def pop(self) -> None:
        r = self.data.pop()
        if r == self.MIN:
            self.MIN = self.data.pop()


    def top(self) -> int:
        return self.data[-1]


    def getMin(self) -> int:
        return self.MIN
