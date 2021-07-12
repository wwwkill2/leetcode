class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 1000
        self.data = []
        for _ in range(self.capacity):
            self.data.append([])
    
    def hash(self, key):
        return key % self.capacity
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        h = self.hash(key)
        for i in range(len(self.data[h])):
            node = self.data[h][i]
            if node[0] == key:
                self.data[h][i] = (key, value)
                return
        self.data[h].append((key, value))
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        h = self.hash(key)
        for i in range(len(self.data[h])):
            node = self.data[h][i]
            if node[0] == key:
                return node[1]
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        h = self.hash(key)
        for i in range(len(self.data[h])):
            node = self.data[h][i]
            if node[0] == key:
                self.data[h].pop(i)
                return
