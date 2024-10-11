import java.util.*;

public class Solution {

    // Class to represent each friend with arrival time, departure time, and unique ID
    static class Friend {
        int arrival;
        int departure;
        int id;

        Friend(int arrival, int departure, int id) {
            this.arrival = arrival;
            this.departure = departure;
            this.id = id;
        }
    }

    /**
     * Finds the seat number assigned to the target friend.
     *
     * @param times        A list of [arrival, departure] times for each friend.
     * @param targetFriend The index of the target friend whose seat number is to be found.
     * @return The seat number assigned to the target friend.
     */
    public static int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // Create a list of Friend objects with their arrival, departure times, and IDs
        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(new Friend(times[i][0], times[i][1], i));
        }

        // Sort friends by arrival time.
        // If arrival times are equal, sort by departure time.
        Collections.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend f1, Friend f2) {
                if (f1.arrival != f2.arrival) {
                    return f1.arrival - f2.arrival;
                } else {
                    return f1.departure - f2.departure;
                }
            }
        });

        // Min-heap to manage available seat numbers (smallest seat number first)
        PriorityQueue<Integer> availableSeats = new PriorityQueue<>();

        // Min-heap to manage occupied seats, sorted by departure time
        // Each entry is a pair [departure_time, seat_number]
        PriorityQueue<int[]> occupiedSeats = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0]; // Sort by departure time
                } else {
                    return a[1] - b[1]; // If departure times are equal, sort by seat number
                }
            }
        });

        // Variable to assign new seat numbers when no available seats are free
        int nextSeatNumber = 0;

        // Variable to store the seat number assigned to the target friend
        int targetSeat = -1;

        // Iterate through each friend in the sorted list
        for (Friend friend : friends) {
            int currentArrival = friend.arrival;
            int currentDeparture = friend.departure;
            int friendId = friend.id;

            // Release seats from friends who have already left before the current friend's arrival
            while (!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] <= currentArrival) {
                int[] freed = occupiedSeats.poll(); // Remove the friend who has left
                int freedSeat = freed[1]; // Get the seat number that has been freed
                availableSeats.offer(freedSeat); // Add the freed seat back to available seats
            }

            int assignedSeat;

            // Assign the smallest available seat if any are free
            if (!availableSeats.isEmpty()) {
                assignedSeat = availableSeats.poll();
            } else {
                // If no seats are available, assign a new seat
                assignedSeat = nextSeatNumber;
                nextSeatNumber++;
            }

            // If the current friend is the target friend, store the assigned seat number
            if (friendId == targetFriend) {
                targetSeat = assignedSeat;
            }

            // Add the current friend's departure time and assigned seat to the occupied seats heap
            occupiedSeats.offer(new int[]{currentDeparture, assignedSeat});
        }

        // Return the seat number assigned to the target friend
        return targetSeat;
    }
}
