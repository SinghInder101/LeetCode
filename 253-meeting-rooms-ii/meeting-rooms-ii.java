import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Sort intervals by starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // List to track end times of meetings
        List<int[]> ans = new ArrayList<>();
        int roomCount = 0;

        for (int[] interval : intervals) {
            // If no meetings are scheduled, add the interval and increase room count
            if (ans.isEmpty()) {
                ans.add(interval);
                roomCount++;
            } 
            else {
                // Check for overlapping intervals
                boolean isAdded = false;
                int i = 0;

                // While loop to compare current interval with all intervals in the list
                while (i < ans.size()) {
                    int[] scheduled = ans.get(i);

                    // If current interval's start time is greater than or equal to an ongoing meeting's end time
                    // No overlap, so you can reuse the room (update the meeting)
                    if (interval[0] >= scheduled[1]) {
                        ans.remove(i); // Remove the old interval that ended
                        ans.add(interval); // Add the new interval
                        isAdded = true;  // Mark that the interval has been added
                        break; // No need to check further, as we have reused the room
                    }
                    i++;
                }

                // If we couldn't find a room to reuse, add a new room
                if (!isAdded) {
                    ans.add(interval); // Allocate a new room
                    roomCount++;
                }
            }
        }

        // Return the number of rooms (which is the size of the 'ans' list)
        return roomCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(sol.minMeetingRooms(intervals)); // Output: 2
    }
}
