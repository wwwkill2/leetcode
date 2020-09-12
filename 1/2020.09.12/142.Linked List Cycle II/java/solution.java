public class Solution {
    public ListNode detectCycle(ListNode head) {
    	ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode begin = head;
				while (begin != slow) {
					begin = begin.next;
					slow = slow.next;
				}
				return begin;
			}
		}
		return null;
    }
    
    public ListNode detectCycle(ListNode head) {
    	try {
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow = slow.next;
            ListNode begin = head;
            while (begin != slow) {
                begin = begin.next;
                slow = slow.next;
            }
            return begin;
        } catch (NullPointerException e) {
            return null;
        }
    }
