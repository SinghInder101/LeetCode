class Solution {
    int ans = 0;
    List<String> fin = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        helper(n, 0, 0,"");
        System.out.println(ans);
        return fin;

    }

    public void helper(int n, int open, int close,String s) {
        if (open == n && close == n) {
            ans++;
            fin.add(s);
            return;
        }

        if (open == 0) {

            helper(n, open + 1, close,s+"(");

        } else {

            if (open == n && close < n) {
                helper(n, open, close + 1,s+")");

            } else if (open < n && close < n) {
                helper(n, open + 1, close,s+"(");
                if(close<open){
                helper(n, open, close + 1,s+")");
                }

            }

        }

    }
}