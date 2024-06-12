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
    private void helper(TreeNode root, int ht, int lvl, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp) {
        if (root == null) {
            return;
        } 

        mp.putIfAbsent(ht, new TreeMap<>());
        mp.get(ht).putIfAbsent(lvl, new PriorityQueue<>());
        mp.get(ht).get(lvl).offer(root.val);

        helper(root.left, ht-1, lvl+1, mp);
        helper(root.right, ht+1, lvl+1, mp);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        helper(root, 0, 0, mp);

        for (TreeMap<Integer, PriorityQueue<Integer>> levelValues : mp.values()) { 
            List<Integer> subAns = new ArrayList<>(); 
            for (PriorityQueue<Integer> sameLevelValues : levelValues.values()) {
                while (!sameLevelValues.isEmpty()) {
                    subAns.add(sameLevelValues.poll());
                }
            }
            ans.add(subAns);
        }

        return ans;
    }
}