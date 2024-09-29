import java.util.*;

class StockPrice {
    HashMap<Integer, Integer> map;   // Stores timestamp to price mapping
    TreeMap<Integer, Integer> freq;  // Stores price to frequency mapping
    int currentTimestamp;            // The latest timestamp

    public StockPrice() {
        this.map = new HashMap<>();
        this.freq = new TreeMap<>();
        this.currentTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            // If the timestamp already exists, update the price
            int oldPrice = map.get(timestamp);
            removePrice(oldPrice);  // Decrement the frequency of the old price
        }

        // Insert/update the new price for the timestamp
        map.put(timestamp, price);
        addPrice(price);  // Increment the frequency of the new price

        // Update the current timestamp if the new timestamp is the latest
        if (timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
        }
    }

    // Removes a price from the frequency map
    private void removePrice(int price) {
        int count = freq.get(price);
        if (count == 1) {
            freq.remove(price);  // If it's the last occurrence, remove the price
        } else {
            freq.put(price, count - 1);  // Otherwise, decrement the count
        }
    }

    // Adds a price to the frequency map
    private void addPrice(int price) {
        freq.put(price, freq.getOrDefault(price, 0) + 1);
    }

    public int current() {
        // Return the price at the latest timestamp
        return map.get(currentTimestamp);
    }

    public int maximum() {
        // Return the maximum price in the TreeMap
        return freq.lastKey();
    }

    public int minimum() {
        // Return the minimum price in the TreeMap
        return freq.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp, price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
