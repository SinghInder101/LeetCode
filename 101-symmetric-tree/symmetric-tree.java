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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);

    
        
    }
    public boolean helper(TreeNode lsb, TreeNode rsb ) {
        if(lsb == null || rsb == null){
            if(lsb==null && rsb == null){
                return true;
            }
            return false;
        }
        boolean leftAns = helper(lsb.left,rsb.right);
        boolean rightAns = helper(lsb.right,rsb.left);
         if(lsb.val != rsb.val){
            return false;
         }
         return leftAns && rightAns;

    }
}