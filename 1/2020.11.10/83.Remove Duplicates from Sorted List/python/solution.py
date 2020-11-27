class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = head
        while head and head.next:
            if head.val == head.next.val:
                head.next = head.next.next
            else:
                head = head.next
        return dummy
