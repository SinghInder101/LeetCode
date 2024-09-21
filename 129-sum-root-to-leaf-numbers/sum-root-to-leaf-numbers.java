class Solution {
    public static int sum = 0;
    static void recur(TreeNode root,int s)
    {
        if(root == null)
            return ;

        if(root.left == null && root.right == null) //leaf
        {
            sum+= Integer.valueOf(s*10 +root.val);
        }

        recur(root.left, s*10 + root.val);
        recur(root.right, s*10 + root.val);
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        recur(root,0);
        return sum;
    }
}