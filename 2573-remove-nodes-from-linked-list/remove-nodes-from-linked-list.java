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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            while (!stk.isEmpty() && stk.peek() < temp.val) {
                stk.pop();
            }
            stk.add(temp.val);
        }

        ListNode newHead = null;
        while (!stk.isEmpty()) {
            ListNode temp = new ListNode();
            temp.val = stk.pop();
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }
}