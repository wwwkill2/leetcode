class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        # recursively
        cur, count = head, 0
        while cur and count != k:
            cur = cur.next;
            count += 1
        if count == k:
            cur = self.reverseKGroup(cur, k);
            while count > 0:
                count -= 1
                tmp = head.next
                head.next = cur
                cur = head
                head = tmp
            head = cur
        return head

    def reverseKGroup2(self, head, k):
        # iteratively
        hair = ListNode(0)
        hair.next = head
        pre = hair
        while head:
            tail = pre
            for _ in range(k):
                tail = tail.next
                if not tail:
                    return hair.next
            nex = tail.next
            head, tail = self.reverse(head, tail)
            pre.next = head
            tail.next = nex
            pre = tail
            head = pre.next
        return hair.next

    def reverse(self, head, tail):
        prev = tail.next
        p = head
        while prev != tail:
            nex = p.next
            p.next = prev
            prev = p
            p = nex
        return tail, head
