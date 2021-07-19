class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        dummy = ListNode()
        while head:
            pre = dummy
            while pre.next:
                if pre.next.val <= head.val:
                    pre = pre.next
                else:
                    break
            nex = head.next
            head.next = pre.next
            pre.next = head
            head = nex
        return dummy.next
