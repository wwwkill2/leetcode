import unittest
import random
from my_sort import bubble_sort, insert_sort, selection_sort, merge_sort, quick_sort

class TestCase(unittest.TestCase):
    def generate_array(self):
        res = []
        for _ in range(200):
            res.append(random.randint(0, 100000))
        return res
    
    def test_bubble_sort(self):
        arr = self.generate_array()
        arr_copy = arr[:]
        arr.sort()
        bubble_sort(arr_copy)
        self.assertEqual(arr, arr_copy)
    
    def test_insert_sort(self):
        arr = self.generate_array()
        arr_copy = arr[:]
        arr.sort()
        insert_sort(arr_copy)
        self.assertEqual(arr, arr_copy)

    def test_selection_sort(self):
        arr = self.generate_array()
        arr_copy = arr[:]
        arr.sort()
        selection_sort(arr_copy)
        self.assertEqual(arr, arr_copy)

    def test_merge_sort(self):
        arr = self.generate_array()
        arr_copy = arr[:]
        arr.sort()
        arr_copy = merge_sort(arr_copy)
        self.assertEqual(arr, arr_copy)

    def test_quick_sort(self):
        arr = self.generate_array()
        arr_copy = arr[:]
        arr.sort()
        quick_sort(arr_copy)
        self.assertEqual(arr, arr_copy)


if __name__ == '__main__':
    unittest.main()
