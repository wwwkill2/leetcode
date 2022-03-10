class Solution {

    private PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    private boolean[] inMST;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        inMST = new boolean[n];
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; ++i) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; ++j) {
                int[] p2 = points[j];
                graph[i].add(new int[]{i, j, Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])});
                graph[j].add(new int[]{j, i, Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])});
            }
        }
        return prim(graph);
    }

    private int prim(List<int[]>[] graph) {
        inMST[0] = true;
        cut(0, graph);
        int weightSum = 0;
        int i = 1;
        while (!heap.isEmpty()) {
            int[] edge = heap.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                continue;
            }
            weightSum += weight;
            inMST[to] = true;
            ++i;
            if (i == graph.length) {
                break;
            }
            cut(to, graph);
        }
        return weightSum;
    }

    private void cut(int s, List<int[]>[] graph) {
        for (int[] edge : graph[s]) {
            int to = edge[1];
            if (inMST[to]) {
                continue;
            }
            heap.offer(edge);
        }
    }
}
