class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return solve(s, wordSet);
    }

    public boolean solve(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                System.out.println("Prefix found: " + prefix);  // Debugging: print found prefixes
            }
            if (wordDict.contains(prefix) && solve(s.substring(i), wordDict)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
