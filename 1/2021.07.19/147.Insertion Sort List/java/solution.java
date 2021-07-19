class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode pre = dummy;
            while (pre.next != null) {
                if (pre.next.val <= head.val) {
                    pre = pre.next;
                } else {
                    break;
                }
            }
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return dummy.next;
    }
}
