import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create an array of ArrayLists to store the two lists of distinct integers
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());  // list for nums1 elements not in nums2
        answer.add(new ArrayList<>());  // list for nums2 elements not in nums1

        // Create sets to store unique values from each array
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Add all elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Add all elements of nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }

        // Find elements in nums1 that are not in nums2
        for (int num : set1) {
            if (!set2.contains(num)) {
                answer.get(0).add(num);
            }
        }

        // Find elements in nums2 that are not in nums1
        for (int num : set2) {
            if (!set1.contains(num)) {
                answer.get(1).add(num);
            }
        }

        return answer;
    }
}
