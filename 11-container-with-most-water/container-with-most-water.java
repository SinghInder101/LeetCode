class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxAns = Integer.MIN_VALUE;
        while (l < r) {
            if (height[l] > height[r]) {
                maxAns = Math.max(maxAns, Math.min(height[l], height[r]) * (r - l));

                r--;
                continue;

            }
            if (height[l] < height[r]) {
                maxAns = Math.max(maxAns, Math.min(height[l], height[r]) * (r - l));
                l++;
                continue;

            }
            if (height[l] == height[r]) {
                maxAns = Math.max(maxAns, height[l] * (r - l));

                l++;
                continue;

            }

        }
        return maxAns;

    }
}