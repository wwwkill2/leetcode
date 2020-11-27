class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        arr = [0 for _ in range(26)]
        for task in tasks:
            arr[ord(task) - ord('A')] += 1
        arr.sort(reverse=True)
        max_val = arr[0] - 1
        slots = max_val * n
        for i in range(1, 26):
            if arr[i] == 0:
                break
            slots -= min(arr[i], max_val)
        return slots + len(tasks) if slots > 0 else len(tasks)
