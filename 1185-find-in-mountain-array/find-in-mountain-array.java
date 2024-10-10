class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        // Find the peak index
        int peakIndex = findPeak(mountainArr, left, right);

        // Check if the peak is the target
        if (mountainArr.get(peakIndex) == target) {
            return peakIndex;
        }

        // Search in the left (ascending) part of the array
        int leftAns = searchLeft(mountainArr, left, peakIndex - 1, target);
        if (leftAns != -1) {
            return leftAns;
        }

        // Search in the right (descending) part of the array
        return searchRight(mountainArr, peakIndex + 1, right, target);
    }

    // Binary search for the left (ascending) part
    public int searchLeft(MountainArray arr, int i, int j, int target) {
        while (i <= j) {
            int mid = (i + j) / 2;
            int midValue = arr.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    // Binary search for the right (descending) part
    public int searchRight(MountainArray arr, int i, int j, int target) {
        while (i <= j) {
            int mid = (i + j) / 2;
            int midValue = arr.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                i = mid + 1;  // Since it's descending, move right if midValue > target
            } else {
                j = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    // Function to find the peak of the mountain array
    public int findPeak(MountainArray arr, int i, int j) {
        while (i < j) {
            int mid = (i + j) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                i = mid + 1;  // Peak is towards the right
            } else {
                j = mid;  // Peak is towards the left
            }
        }
        return i;  // i and j converge to the peak
    }
}