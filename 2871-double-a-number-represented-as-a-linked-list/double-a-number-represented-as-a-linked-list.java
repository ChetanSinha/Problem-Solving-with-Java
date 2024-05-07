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
    public ListNode doubleIt(ListNode head) {
        ListNode temp = head;
        if (head.val >= 5) {
            ListNode node = new ListNode(1, head);
            head = node;
        }

        int val;
        while (temp.next != null) {
            val = temp.val * 2;
            if (temp.next.val >= 5) {
                val += 1;
            }
            temp.val = val % 10;
            temp = temp.next;
        }
        temp.val = (temp.val * 2) % 10;
        return head;
    }
}