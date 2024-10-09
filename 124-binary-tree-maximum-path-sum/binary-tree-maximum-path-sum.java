/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Pair {
    public int a;
    public int b;

    Pair() {
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;

    }

}

class Solution {
    public int maxPathSum(TreeNode root) {
        Pair ans = helper(root);
        return Math.max(ans.a, ans.b);

    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair();
        }
        Pair leftAns = helper(root.left);
        if (leftAns.b < 0) {
            leftAns.b = 0;
        }
        Pair rightAns = helper(root.right);
        if (rightAns.b < 0) {
            rightAns.b = 0;

        }

        int rootIncluding = root.val + Math.max(leftAns.b, rightAns.b);
        int rootVal = root.val;

        Pair ans = new Pair();
        ans.a = Math.max(leftAns.a, Math.max(rightAns.a, root.val + leftAns.b + rightAns.b));

        ans.b = Math.max(rootIncluding, rootVal);

        return ans;

    }

}