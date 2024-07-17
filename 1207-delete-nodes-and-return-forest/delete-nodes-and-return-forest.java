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
    List<TreeNode> ans;
    HashSet<Integer> set;

    public TreeNode insertRoots(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = insertRoots(root.left);
        TreeNode right = insertRoots(root.right);

        if (set.contains(root.val)) {
            if (left != null) {
                ans.add(left);
            }
            if (right != null) {
                ans.add(right);
            }
            return null;
        } else {
            root.left = left;
            root.right = right;
            return root;
        }
    }


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        for (int i=0; i<to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        TreeNode newRoot = insertRoots(root);
        if (newRoot != null) {
            ans.add(newRoot);
        }
        return ans;
    }
}