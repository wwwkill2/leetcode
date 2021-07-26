class Solution {
    public ListNode sortList(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int len = 1; len < length; len *= 2) {
            ListNode pre = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < len && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < len && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                if (cur != null) {
                    ListNode next = cur.next;
                    cur.next = null;
                    cur = next;
                }
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
