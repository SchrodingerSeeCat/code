package linkllist;

// https://leetcode-cn.com/problems/rotate-list/
public class P_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode before = head, after = head;

        // 统计链表的长度
        int count = 0;
        while (before != null) {
            before = before.next;
            count++;
        }

        // 计算k的模
        k = k % count;
        count = 0;
        before = head;

        while (after.next != null) {
            if (count < k) {
                count++;
            } else {
                before = before.next;
            }
            after = after.next;
        }

        // 将后k个元素插入到头节点之前
        after.next = head;
        head = before.next;

        // 尾指针置空
        before.next = null;
        return head;
    }
}
