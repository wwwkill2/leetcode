class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # recursively
        if not head or not head.next:
            return head
        p = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return p

    def reverseList(self, head: ListNode) -> ListNode:
        # iteratively
        dummy = None
        while head:
            p = head.next
            head.next, dummy = dummy, head
            head = p
        return dummy
