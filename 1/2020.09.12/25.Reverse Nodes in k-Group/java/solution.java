class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
		// recursively
		ListNode cur = head;
		int count = 0;
		while (cur != null && count != k ) {
			cur = cur.next;
			count++;
		}
		if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count > 0) {
				count--;
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
			}
			head = cur;
		}
		return head;
	}
	
	public ListNode reverseKGroup2(ListNode head, int k) {
		// iteratively
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode begin = dummy;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode begin, ListNode end) {
		ListNode result = begin.next;
		ListNode cur = result;
		ListNode prev = begin;
		while (cur != end) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		begin.next = prev;
		result.next = end;
		return result;
	}
}
