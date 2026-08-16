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
    public int maxans = Integer.MIN_VALUE ; 
    public int maxPathUtil(TreeNode root ){
        if(root==null){
            return 0 ; 
        }

      int left = Math.max(0, maxPathUtil(root.left));
int right = Math.max(0, maxPathUtil(root.right)); 

       maxans = Math.max(maxans, left + right + root.val);

return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0 ; 
        }
int ans = maxPathUtil(root);
        return maxans ; 
    }
}
