class Solution {
    public int maximumInvitations(int[] g) {
        int n = g.length;
        int[] deg = new int[n];
        int[] maxDepth = new int[n];
        for (int w : g) {
            ++deg[w];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (deg[i] == 0) {
                q.offerLast(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.pollFirst();
            ++maxDepth[v];
            int w = g[v];
            maxDepth[w] = Math.max(maxDepth[w], maxDepth[v]);
            --deg[w];
            if (deg[w] == 0) {
                q.offerLast(w);
            }
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; ++i) {
            if (deg[i] == 0) {
                continue;
            }
            deg[i] = 0;
            int ringSize = 1;
            int v = g[i];
            while (v != i) {
                deg[v] = 0;
                ++ringSize;
                v = g[v];
            }
            if (ringSize == 2) {
                sumChainSize += maxDepth[i] + maxDepth[g[i]] + 2;
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(maxRingSize, sumChainSize);
    }
}
