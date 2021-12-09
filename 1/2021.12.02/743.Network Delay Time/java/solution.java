class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        int[] distTo = dijkstra(k, graph);
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    private int[] dijkstra(int start, List<int[]>[] graph) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
        heap.offer(new State(start, 0));
        while (!heap.isEmpty()) {
            State curState = heap.poll();
            int curNodeId = curState.nodeId;
            int curDistFromStart = curState.distFromStart;
            if (curDistFromStart > distTo[curNodeId]) {
                continue;
            }
            for (int[] neighbor : graph[curNodeId]) {
                int nextNodeId = neighbor[0];
                int distToNextNode = curDistFromStart + neighbor[1];
                if (distToNextNode < distTo[nextNodeId]) {
                    distTo[nextNodeId] = distToNextNode;
                    heap.offer(new State(nextNodeId, distToNextNode));
                }
            }
        }
        return distTo;
    }
}

class State {
    int nodeId;
    int distFromStart;

    public State(int nodeId, int distFromStart) {
        this.nodeId = nodeId;
        this.distFromStart = distFromStart;
    }
}
