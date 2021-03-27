class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // iteratively
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        pre.next = head;
        while (pre.next != null) {
            ListNode h = pre.next;
            ListNode tail = h;
            for (int i = 0; i < k - 1; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            pre.next = reverse(h, tail);
            pre = h;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode end = tail.next;
        while (head != end) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return tail;
    }
}
