class Solution {
    class Triplets {
        double fraction;
        int i;
        int j;
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Triplets> pq = new PriorityQueue<>((a, b) -> Double.compare(a.fraction, b.fraction));
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                Triplets t = new Triplets();
                t.fraction = (double )arr[i]/arr[j];
                t.i = arr[i];
                t.j = arr[j];
                pq.add(t);
            }
        }

        while (k != 1) {
            Triplets t = pq.poll();
            // System.out.println(t.i + " " + t.j);
            k -= 1;
        }

        Triplets t = pq.poll();
        // System.out.println(t.fraction);
        return new int[]{t.i, t.j};
    }
}