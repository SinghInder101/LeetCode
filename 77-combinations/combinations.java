class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        ArrayList<Integer> currentCombination = new ArrayList<>();
        helper(n, k, 1, currentCombination);
        return ans;

    }

    public void helper(int n, int k, int curr, ArrayList<Integer> currentCombination) {
        if (currentCombination.size() == k) {
            ans.add(new ArrayList<>(currentCombination));

            return;

        }

        for (int i = curr; i <= n; i++) {

            currentCombination.add(i);
            helper(n, k, i + 1, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);

        }
        return;
    }
}