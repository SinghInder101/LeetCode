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
   List<TreeNode> nodeList = new ArrayList<>();
    TreeNode init;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
             Map<Integer, Boolean> deleteMap = new HashMap<>();
        
        // Put all the values from to_delete array into the HashSet
         for (int value : to_delete) {
            deleteMap.put(value, true);
        }
        init = root;
        TreeNode ans = deleteNodes(init,deleteMap,root,"");
        if(ans!= null){
        nodeList.add(ans);
        }
        
        return nodeList;
        
      
        
    }
     public TreeNode deleteNodes(TreeNode root,  Map<Integer, Boolean> deleteMap,TreeNode parent,String Direction){
         if(root == null){
             return null;
         }
         
      
             parent = root;
             TreeNode left = deleteNodes(root.left,deleteMap,parent,"left");
             TreeNode right = deleteNodes(root.right,deleteMap,parent,"right");
             
            if(deleteMap.containsKey(root.val)){
                if(left!=null){
                nodeList.add(left);
                }
                if(right!= null){
                nodeList.add(right);
                }
             root = null;
                
            }
         else{
             if(root.left != null && deleteMap.containsKey(root.left.val)){
                 root.left = null;
             }
             
             
              if(root.right != null && deleteMap.containsKey(root.right.val)){
                 root.right = null;
             }
         }
         
        
         return root;
         
        
         
     }
}