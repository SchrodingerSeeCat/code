package linkllist;

public class P_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode before = head, after = head;
        int count = n + 1;
        while(after != null) {
            if (count > 0) {
                count--;
            } else {
                before = before.next;
            }
            after = after.next;
        }
        if (count > 0) return head.next;
        if (before != null && before.next != null) {
            before.next = before.next.next;
        }
        return head;
    }
}
