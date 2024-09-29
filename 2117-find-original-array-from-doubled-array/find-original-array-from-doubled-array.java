import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        // If the length is odd, we cannot form the original array
        if (changed.length % 2 != 0) {
            return new int[0];
        }

        // Sort the array to process smaller elements first
        Arrays.sort(changed);

        // Map to store the frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> original = new ArrayList<>();

        // Count the frequency of each number in the `changed` array
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through the sorted array
        for (int num : changed) {
            // If `num` is already used (frequency is 0), skip it
            if (map.get(num) == 0) {
                continue;
            }

            // Check if we can find `num * 2` in the map with non-zero frequency
            int doubleNum = num * 2;
            if (map.getOrDefault(doubleNum, 0) > 0) {
                // Add `num` to the original array
                original.add(num);

                // Decrease the frequency of `num` and `num * 2`
                map.put(num, map.get(num) - 1);
                map.put(doubleNum, map.get(doubleNum) - 1);
            } else {
                // If we can't find a valid double, return an empty array
                return new int[0];
            }
        }

        // Convert the ArrayList `original` to a primitive int array and return
        int[] result = new int[original.size()];
        for (int i = 0; i < original.size(); i++) {
            result[i] = original.get(i);
        }

        return result;
    }
}
