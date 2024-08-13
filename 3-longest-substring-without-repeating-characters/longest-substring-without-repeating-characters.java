class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end)) || map.get(s.charAt(end)) < start) {
                map.put(s.charAt(end), end);
                ans = Math.max(ans, end-start+1);
            } else {
                start = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end), end);
            }
            end += 1;
        }

        return ans;
    }
}