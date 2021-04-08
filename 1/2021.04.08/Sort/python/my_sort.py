def bubble_sort(nums):
    n = len(nums)
    if n < 2:
        return
    for i in range(n - 1):
        flag = False
        for j in range(n - i - 1):
            if nums[j] > nums[j+1]:
                nums[j], nums[j+1] = nums[j+1], nums[j]
                flag = True
        if not flag:
            return


def insert_sort(nums):
    n = len(nums)
    for i in range(1, n):
        num = nums[i]
        j = i - 1
        while j >= 0:
            if nums[j] > num:
                nums[j+1] = nums[j]
                j -= 1
            else:
                break
        nums[j+1] = num


def selection_sort(nums):
    n = len(nums)
    if n < 2:
        return
    for i in range(n - 1):
        min_index = i
        for j in range(i + 1, n):
            if nums[j] < nums[min_index]:
                min_index = j
        nums[i], nums[min_index] = nums[min_index], nums[i]


def merge_sort(nums):
    return _merge_sort(nums, 0, len(nums) - 1)


def _merge_sort(nums, start, end):
    if start == end:
        return nums[start: start + 1]
    mid = start + (end - start) // 2
    left = _merge_sort(nums, start, mid)
    right = _merge_sort(nums, mid + 1, end)
    return _merge(left, right)


def _merge(left, right):
    res = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            res.append(left[i])
            i += 1
        else:
            res.append(right[j])
            j += 1
    if i < len(left):
        res.extend(left[i:])
    else:
        res.extend(right[j:])
    return res


def quick_sort(nums):
    _quick_sort(nums, 0, len(nums) - 1)

def _quick_sort(nums, start, end):
    if start >= end:
        return
    pivot = partition(nums, start, end)
    _quick_sort(nums, start, pivot - 1)
    _quick_sort(nums, pivot + 1, end)

def partition(nums, start, end):
    pivot = nums[end]
    i = start
    for j in range(start, end):
        if nums[j] < pivot:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
    nums[i], nums[end] = nums[end], nums[i]
    return i

