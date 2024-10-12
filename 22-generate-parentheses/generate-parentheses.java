import java.util.*;

public class Solution {
    private Map<String, List<String>> memo = new HashMap<>(); // Memoization cache
    private List<String> fin = new ArrayList<>(); // Final results list
    private int ans = 0; // Counter for valid combinations

    public void helper(int n, int open, int close, String s) {
        // Base case: If open and close are both equal to n
        if (open == n && close == n) {
            ans++;
            fin.add(s);
            return;
        }

        // Create a unique key for the current state
        String key = open + "," + close + "," + s;

        // If the result for this state is already computed, return
        if (memo.containsKey(key)) {
            fin.addAll(memo.get(key));
            return;
        }

        List<String> currentResult = new ArrayList<>();

        if (open == 0) {
            helper(n, open + 1, close, s + "(");
        } else {
            if (open == n && close < n) {
                helper(n, open, close + 1, s + ")");
            } else if (open < n && close < n) {
                helper(n, open + 1, close, s + "(");
                if (close < open) {
                    helper(n, open, close + 1, s + ")");
                }
            }
        }

        // Store the result for this state in the memoization map
        memo.put(key, new ArrayList<>(fin));
    }

    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return fin;
    }

  
}
