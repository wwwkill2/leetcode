class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                begin = head
                while begin is not slow:
                    begin = begin.next
                    slow = slow.next
                return begin
        return None


    def detectCycle2(self, head: ListNode) -> ListNode:
        try:
            slow = head
            fast = head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            slow = slow.next
            begin = head
            while begin is not slow:
                begin = begin.next
                slow = slow.next
            return begin
        except:
            return None

