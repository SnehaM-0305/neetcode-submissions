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

    public int height(TreeNode root){
        if(root==null){
            return 0 ; 
        }
        int lefth = height(root.left) ; 
        int righth = height(root.right) ; 

        return Math.max(lefth,righth)+1 ; 
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftdiam = diameterOfBinaryTree(root.left) ; 
        int rightdiam = diameterOfBinaryTree(root.right) ; 

        int currdiam = height(root.left) +height(root.right) ; 

        return Math.max(currdiam , Math.max(leftdiam,rightdiam)) ; 

    }
}
