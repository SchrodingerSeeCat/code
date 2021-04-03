package linkllist;

public class P_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode next = null;
        while(pre != null && pre.next != null) {
            while (pre.next != null && pre.val == pre.next.val) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return head;
    }
}
