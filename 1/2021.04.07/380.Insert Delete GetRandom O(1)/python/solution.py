class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = {}
        self.list = []
        

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.dict:
            return False
        self.dict[val] = len(self.list)
        self.list.append(val)
        return True
        

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.dict:
            return False
        index = self.dict[val]
        if index != len(self.list) - 1:
            self.list[index] = self.list[-1]
            self.dict[self.list[index]] = index
        self.dict.pop(val)
        self.list.pop()
        return True
        

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return choice(self.list)
