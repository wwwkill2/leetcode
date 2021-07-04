class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        def get_kth_element(k):
            index1 = index2 = 0
            while True:
                if index1 == len(nums1):
                    return nums2[index2 + k - 1]
                if index2 == len(nums2):
                    return nums1[index1 + k - 1]
                if k == 1:
                    return min(nums1[index1], nums2[index2])
                half = k // 2
                new_index1, new_index2 = min(len(nums1) - 1, index1 + half - 1), min(len(nums2) - 1, index2 + half - 1)
                pivot1, pivot2 = nums1[new_index1], nums2[new_index2]
                if pivot1 <= pivot2:
                    k -= new_index1 - index1 + 1
                    index1 = new_index1 + 1
                else:
                    k -= new_index2 - index2 + 1
                    index2 = new_index2 + 1
        
        total = len(nums1) + len(nums2)
        if total % 2 == 1:
            return get_kth_element(total // 2 + 1)
        return (get_kth_element(total // 2) + get_kth_element(total // 2 + 1)) / 2
