class Solution {
    class Triplets {
        double fraction;
        int i;
        int j;
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Triplets> pq = new PriorityQueue<>((a, b) -> Double.compare(b.fraction, a.fraction));

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                Triplets t = new Triplets();
                t.fraction = (double )arr[i]/arr[j];
                t.i = arr[i];
                t.j = arr[j];
                pq.add(t);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        Triplets t = pq.poll();
        return new int[]{t.i, t.j};
    }
}