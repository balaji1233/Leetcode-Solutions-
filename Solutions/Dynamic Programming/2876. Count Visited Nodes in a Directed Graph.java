class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int[] ans = new int[edges.size()];
        int[][] visited = new int[2][ans.length];
        Arrays.fill(visited[0], -1);
        for (int i = 0; i < edges.size(); i++) {
            int t = i;
            if (visited[0][t] >= 0) {
                continue;
            }
            int count = 1;
            while (visited[0][t] == -1) {
                visited[0][t] = i;
                visited[1][t] = count++;
                t = edges.get(t);
            }
            if (visited[0][t] == i) {
                int cycle = count - visited[1][t];
                int prev = visited[1][t] - 1;
                int tt = i;
                while (tt != t) {
                    ans[tt] = cycle + prev--;
                    tt = edges.get(tt);
                }
                ans[t] = cycle;
                tt = edges.get(t);
                while (tt != t) {
                    ans[tt] = cycle;
                    tt = edges.get(tt);
                }
            } else {
                int next = ans[t];
                int prev = count - 1;
                int tt = i;
                while (tt != t) {
                    ans[tt] = next + prev--;
                    tt = edges.get(tt);
                }
            }
        }
        return ans;
    }
}
