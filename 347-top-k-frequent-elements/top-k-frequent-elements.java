class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Step 1: Create a HashMap to store the frequency of each element in the array.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Increment the frequency count of the number (default to 0 if it doesn't exist).
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Create an array of ArrayLists, where index represents frequency,
        // and the list at that index stores all elements with that frequency.
        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];  // nums.length + 1 because frequency ranges from 1 to nums.length

        for (int key : map.keySet()) {
            int frequency = map.get(key);  // Get the frequency of each key.
            
            // If the list at this frequency is not initialized, initialize it.
            if (arr[frequency] == null) {
                arr[frequency] = new ArrayList<Integer>();
            }
            
            // Add the key (number) to the corresponding frequency list.
            arr[frequency].add(key);
        }

        // Step 3: Collect the top K frequent elements from the frequency array.
        int[] res = new int[k];  // Array to store the result.
        k--;  // Decrement k so we can use it as an index (0-based) for the result array.

        // Traverse the frequency array from the highest possible frequency (nums.length) down to 0.
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) {  // If there's an ArrayList at this frequency.
                for (Integer num : arr[i]) {  // Iterate through the numbers at this frequency.
                    res[k--] = num;  // Add the number to the result array.
                    
                    // If we've added K elements, break out of both loops.
                    if (k == -1) {
                        break;
                    }
                }
            }
            
            // Break the outer loop if we've added K elements.
            if (k == -1) {
                break;
            }
        }

        return res;  // Return the top K frequent elements.
    }
}
