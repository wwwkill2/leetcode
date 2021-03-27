class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        def reverse(head, tail):
            pre = end = tail.next
            while head != end:
                next = head.next
                head.next = pre
                pre = head
                head = next
            return pre
        
        dummy = ListNode()
        pre = dummy
        pre.next = head
        while pre.next:
            h = tail = pre.next
            for _ in range(k - 1):
                tail = tail.next
                if not tail:
                    return dummy.next
            pre.next = reverse(h, tail)
            pre = h
        return dummy.next
