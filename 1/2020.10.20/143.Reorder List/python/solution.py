class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        def find_mid():
            slow = fast = head
            while fast.next and fast.next.next:
                slow = slow.next
                fast = fast.next.next
            return slow
        
        def reverse(root):
            if not root or not root.next:
                return root
            p = reverse(root.next)
            root.next.next = root
            root.next = None
            return p
        
        def merge(l1, l2):
            while l1 and l2:
                n1, n2 = l1.next, l2.next
                l1.next = l2
                l2.next = n1
                l1, l2 = n1, n2
        if not head or not head.next:
            return
        mid = find_mid()
        l1 = head
        l2 = mid.next
        mid.next = None
        l2 = reverse(l2)
        merge(l1, l2)
