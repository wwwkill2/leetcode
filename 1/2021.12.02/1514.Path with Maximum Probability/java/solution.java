class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; ++i) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{to, weight});
            graph[to].add(new double[]{from, weight});
        }
        return dijkstra(start, end, graph);
    }

    private double dijkstra(int start, int end, List<double[]>[] graph) {
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo, -1);
        probTo[start] = 1;

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });
        heap.offer(new State(start, 1));
        while (!heap.isEmpty()) {
            State curState = heap.poll();
            int curNodeId = curState.id;
            double curProbFromStart = curState.probFromStart;

            if (curNodeId == end) {
                return curProbFromStart;
            }
            if (curProbFromStart < probTo[curNodeId]) {
                continue;
            }
            for (double[] neighbor : graph[curNodeId]) {
                int nextNodeId = (int) neighbor[0];
                double probToNextNode = curProbFromStart * neighbor[1];
                if (probTo[nextNodeId] < probToNextNode) {
                    probTo[nextNodeId] = probToNextNode;
                    heap.offer(new State(nextNodeId, probToNextNode));
                }
            }
        }
        return 0.0;
    }
}

class State {
    int id;
    double probFromStart;

    public State(int id, double probFromStart) {
        this.id = id;
        this.probFromStart = probFromStart;
    }
}
