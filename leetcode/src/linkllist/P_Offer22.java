package linkllist;

// https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
public class P_Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode newHead = head;
        int count = k;
        while(head != null) {
            if (count > 0) {
                count--;
            } else {
                newHead = newHead.next;
            }
            head = head.next;
        }
        if (count > 0) return null;
        return newHead;
    }
}
