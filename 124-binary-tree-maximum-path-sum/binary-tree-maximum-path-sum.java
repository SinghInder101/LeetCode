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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int ans = helper(root);
        return Math.max(max,ans);
        
    }
    public int helper(TreeNode root){
        if(root== null){
            return 0;
        }
        int leftAns = helper(root.left);
        if(leftAns<0){
            leftAns = 0;
        }
        int rightAns = helper(root.right);
          if(rightAns<0){
            rightAns = 0;
        }
        
        max = Math.max(max,leftAns+rightAns+root.val);
        int leftOrRight = Math.max(leftAns,rightAns) + root.val;
        return Math.max(leftOrRight,root.val); 
    }
    

}