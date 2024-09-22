class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int maxStreak = 0;
        
        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currStreak++;
                }
                
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        
        return maxStreak;
    }
}
