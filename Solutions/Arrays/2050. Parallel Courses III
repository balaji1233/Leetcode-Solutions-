class Solution {
        public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indeg = new int[n], elapsed = new int[n];
        List<Integer>[] adj = new List[n];
        Arrays.setAll(adj, x -> new ArrayList<>());
        for (int[] r : relations) {
            adj[r[0]- 1].add(r[1] - 1);
            indeg[r[1]- 1]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i)
            if (indeg[i] == 0) {
                q.offer(i);
                elapsed[i] += time[i];
            }
        int res = 0;
        while (!q.isEmpty()) {
            int f = q.poll();
            res = Math.max(res, elapsed[f]);
            for (Integer ch : adj[f]) {
                elapsed[ch] = Math.max(elapsed[ch], elapsed[f]);
                if (--indeg[ch] == 0) {
                    elapsed[ch] += time[ch];
                    q.offer(ch);
                }
            }
        }
        return res;
    }
}
