import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // Create a list of friends with arrival, departure, and index
        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(new Friend(times[i][0], times[i][1], i));
        }

        // Sort friends by arrival time
        friends.sort(Comparator.comparingInt(a -> a.arrival));

        // Min-heap for available seats
        PriorityQueue<Integer> availableSeats = new PriorityQueue<>();

        // Min-heap for occupied seats based on departure time
        PriorityQueue<OccupiedSeat> occupiedSeats = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.departure)
        );

        int nextSeat = 0;

        for (Friend friend : friends) {
            int arrival = friend.arrival;
            int departure = friend.departure;
            int index = friend.index;

            // Free up seats from friends who have departed by now
            while (!occupiedSeats.isEmpty() && occupiedSeats.peek().departure <= arrival) {
                int freedSeat = occupiedSeats.poll().seat;
                availableSeats.offer(freedSeat);
            }

            // Assign the lowest-numbered available seat
            int seat;
            if (!availableSeats.isEmpty()) {
                seat = availableSeats.poll();
            } else {
                seat = nextSeat++;
            }

            // If this is the target friend, return the seat
            if (index == targetFriend) {
                return seat;
            }

            // Mark the seat as occupied
            occupiedSeats.offer(new OccupiedSeat(departure, seat));
        }

        // If targetFriend was not found, return -1 or handle accordingly
        return -1;
    }

    // Helper class to represent a friend
    static class Friend {
        int arrival;
        int departure;
        int index;

        Friend(int arrival, int departure, int index) {
            this.arrival = arrival;
            this.departure = departure;
            this.index = index;
        }
    }

    // Helper class to represent an occupied seat
    static class OccupiedSeat {
        int departure;
        int seat;

        OccupiedSeat(int departure, int seat) {
            this.departure = departure;
            this.seat = seat;
        }
    }

    // Example usage (for testing purposes)
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = { {1, 4}, {2, 3}, {4, 6} };
        int targetFriend = 1;
        int seatNumber = solution.smallestChair(times, targetFriend);
        System.out.println(seatNumber); // Output: 1
    }
}

