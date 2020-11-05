package linkllist;

class P_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = head;
        int count = 1;
        while (tempHead.next != null) {
            tempHead = tempHead.next;
            count++;
        }
        if (count == 1) {
            return null;
        }
        if (n == 1) {
            tempHead.next = null;
            return head;
        }
        tempHead = head;
        int position = count - n - 1;
        if (count > 0) {
            for (int i = 0; i < position; i++){
                tempHead = tempHead.next;
            }
            tempHead.next = tempHead.next.next;
        } else {
            head.next = head.next.next;
        }
        return head;
    }
}
