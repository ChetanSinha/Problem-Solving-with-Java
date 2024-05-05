/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    PriorityQueue<Integer> pq;

    private void func(TreeNode root) {
        if (root == null) {
            return;
        }
        func(root.left);
        pq.add(root.val);
        func(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue<>();
        func(root);

        int ans = 0;
        while (k > 0) {
            ans = pq.poll();
            k -= 1;
        }

        return ans;
    }
}