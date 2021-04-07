class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.res = []
        for child in nestedList:
            self.DFS(child)
        self.size = len(self.res)
        self.index = -1
    
    def next(self) -> int:
        self.index += 1
        return self.res[self.index]
    
    def hasNext(self) -> bool:
        return self.index + 1 < self.size

    def DFS(self, root):
        if root.isInteger():
            self.res.append(root.getInteger())
            return
        for child in root.getList():
            self.DFS(child)
