class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int length = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and the index is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // Update the left pointer to exclude the duplicate character
                left = map.get(currentChar) + 1;
            }

            // Update the character's most recent index
            map.put(currentChar, right);

            // Update the maximum length
            length = Math.max(length, right - left + 1);
        }

        // You can print the final result if you want to check the answer

        return length;
    }
}
