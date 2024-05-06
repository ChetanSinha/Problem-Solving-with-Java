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
        List<Integer> arr = new ArrayList<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            arr.add(temp.val);
        }

        int mx = -1;
        for (int i=arr.size()-1; i>=0; i--) {
            int val = (mx > arr.get(i)) ? 0 : 1;
            mx = Math.max(mx, arr.get(i));
            arr.set(i, val);
        }

        int idx = 0;
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            // System.out.println(arr.get(idx));
            if (arr.get(idx) == 0) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
            idx += 1;
        }

        return head;
    }
}