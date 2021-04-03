package linkllist;

// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
public class P_Offer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode r = head.next.next;
        head.next = null;
        while (p != null) {
            p.next = head;
            head = p;
            p = r;
            if (r != null) r = r.next;
        }
        return head;
    }
}
