class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return (nums[0] > nums[1]) ? 0 : 1;
        }

        int low = 0;
        int high = n-1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && mid < n && nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if (nums[mid] > nums[mid+1]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }
}