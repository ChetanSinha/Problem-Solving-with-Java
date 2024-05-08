class Solution {
    class Pair {
        int val;
        int idx;
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val-a.val);
        for (int i=0; i<score.length; i++) {
            Pair p = new Pair();
            p.val = score[i];
            p.idx = i;
            pq.offer(p);
        }
        
        int i = 1;
        String[] ans = new String[score.length];
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            String rank;
            if (i == 1) {
                rank = "Gold Medal";
            } else if (i == 2) {
                rank = "Silver Medal";
            } else if (i == 3) {
                rank = "Bronze Medal";
            } else {
                rank = String.valueOf(i);
            }
            ans[p.idx] = rank;
            i += 1;
        }

        return ans;
    }
}