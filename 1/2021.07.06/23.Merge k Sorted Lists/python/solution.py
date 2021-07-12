class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        def merge(left, right):
            if left == right:
                return lists[left]
            if left > right:
                return None
            mid = left + (right - left) // 2
            return merge_two(merge(left, mid), merge(mid + 1, right))
        
        def merge_two(l1, l2):
            dummy = cur = ListNode()
            while l1 and l2:
                if l1.val <= l2.val:
                    cur.next = l1
                    l1 = l1.next
                else:
                    cur.next = l2
                    l2 = l2.next
                cur = cur.next
            cur.next = l1 or l2
            return dummy.next
        
        return merge(0, len(lists) - 1)

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        heap = []
        for i, node in enumerate(lists):
            if node:
                heappush(heap, (node.val, i, node))
        dummy = cur = ListNode()
        while heap:
            _, i, node = heappop(heap)
            cur.next = node
            cur = cur.next
            node = node.next
            if node:
                heappush(heap, (node.val, i, node))
        return dummy.next
