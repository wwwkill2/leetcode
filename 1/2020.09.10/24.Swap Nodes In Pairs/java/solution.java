class Solution {
    public ListNode swapPairs(ListNode head) {
        // recursive
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        // iterate
        ListNode pre = new ListNode();
        ListNode result = pre;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = a.next;
            ListNode bNext = b.next;
            a.next = bNext;
            b.next = a;
            pre.next = b;
            pre = a;
        }
        return result.next;
    }
}