class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        def reverseN(head, n):
            if n == 1:
                self.successor = head.next
                return head
            last = reverseN(head.next, n - 1)
            head.next.next = head
            head.next = self.successor
            return last
        
        if left == 1:
            return reverseN(head, right)
        head.next = self.reverseBetween(head.next, left - 1, right - 1)
        return head
