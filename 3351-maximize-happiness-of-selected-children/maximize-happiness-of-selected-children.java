class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int len = happiness.length;
        int dec = 0;
        long ans = 0;
        for (int i = len-1; i > len-k-1; i--) {
            if ((happiness[i]-dec) > 0) {
                // System.out.println(happiness[i]);
                ans += (happiness[i] - dec);
            }
            dec += 1;
        }
        return ans;
    }
}