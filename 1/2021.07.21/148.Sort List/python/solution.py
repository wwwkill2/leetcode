class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        def merge(l1, l2):
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
        
        node = head
        length = 0
        while node:
            length += 1
            node = node.next
        dummy = ListNode()
        dummy.next = head
        sub_len = 1
        while sub_len < length:
            pre, cur = dummy, dummy.next
            while cur:
                head1 = cur
                for _ in range(1, sub_len):
                    if not cur.next:
                        break
                    cur = cur.next
                head2 = cur.next
                cur.next = None
                cur = head2
                for _ in range(1, sub_len):
                    if not cur or not cur.next:
                        break
                    cur = cur.next
                if cur:
                    cur.next, cur = None, cur.next
                pre.next = merge(head1, head2)
                while pre.next:
                    pre = pre.next
            sub_len *= 2
        return dummy.next
