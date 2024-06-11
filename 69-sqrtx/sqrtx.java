class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high-low)/2;
            int div = x / mid;
            if (div == mid) {
                return mid;
            } else if (div > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}