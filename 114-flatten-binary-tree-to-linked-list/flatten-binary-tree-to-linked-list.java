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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left == null && root.right == null){
            return;

        }
        if(root.left ==null && root.right !=  null){
            return;
        }
        if(root.left != null && root.right == null){
            root.right = root.left;
            root.left =null;
            return;
        }
        TreeNode RightTemp = root.right;
        TreeNode LeftTemp = root.left;
        while(LeftTemp.right!=null){
         
            LeftTemp = LeftTemp.right;
            
        }
        LeftTemp.right = RightTemp;
        root.right= root.left;
        root.left = null;
       
        return;
      
        
    }
}