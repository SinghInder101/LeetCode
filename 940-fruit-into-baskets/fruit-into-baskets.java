import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalAns = 0;

        for (right = 0; right < fruits.length; right++) {
            // Add the current fruit to the map and update its count
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If the map contains more than 2 types of fruits, adjust the left pointer
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++; // Shrink the window
            }

            // Calculate the maximum number of fruits that can be picked
            totalAns = Math.max(totalAns, right - left + 1);
        }

        return totalAns;
    }
}
