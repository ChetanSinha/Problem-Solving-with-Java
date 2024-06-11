class Solution {
    // length will always be odd
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }

        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            boolean isOddIdx = (mid % 2 != 0) ? true : false;

            if (isOddIdx) {
                if (nums[mid-1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid-1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}