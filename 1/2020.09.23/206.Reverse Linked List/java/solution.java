class Solution {
    public ListNode reverseList(ListNode head) {
        // iteratively
        ListNode dummy = null;
        while (head != null) {
            ListNode p = head.next;
            head.next = dummy;
            dummy = head;
            head = p;
        }
        return dummy;
    }

    public ListNode reverseList(ListNode head) {
        // recursively
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
