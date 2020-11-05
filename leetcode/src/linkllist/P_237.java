package linkllist;
/*
* https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
* 思路：
* 将当前节点的next节点的值覆盖到当前节点的值，将当前节点的next指向当前节点的next的next
* */
public class P_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
