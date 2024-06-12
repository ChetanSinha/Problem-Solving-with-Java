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
    int mx;
    private void helper(TreeNode root, int cur, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (mx < cur) {
            mx = cur;
            ans.add(root.val);
        }

        helper(root.right, cur+1, ans);
        helper(root.left, cur+1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        mx = -1;
        helper(root, 0, ans);
        return ans;
    }
}