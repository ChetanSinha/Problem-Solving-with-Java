/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode temp = newHead;
        int carry = 0;
        int val;
        while (temp.next != null) {
            val = (temp.val * 2 + carry);
            carry = val / 10;
            temp.val = val % 10;
            temp = temp.next;
        }
        val = (temp.val * 2 + carry);
        carry = val / 10;
        temp.val = val % 10;
        
        if (carry != 0) {
            ListNode newNode = new ListNode();
            newNode.val = carry;
            newNode.next = null;
            temp.next = newNode;
        }

        return reverse(newHead);
    }
}