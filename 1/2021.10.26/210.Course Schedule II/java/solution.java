class Solution {

    private List<List<Integer>> graph = new ArrayList<>();
    private int[] visited;
    private int[] res;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // DFS
        visited = new int[numCourses];
        res = new int[numCourses];
        // build inverse adjacent
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (DFS(i)) {
                return new int[0];
            }
        }
        return res;
    }

    private boolean DFS(int i) {
        if (visited[i] == 1) {
            // has cycle
            return true;
        }
        if (visited[i] == 2) {
            // already traversaled
            return false;
        }
        visited[i] = 1;
        for (int j : graph.get(i)) {
            if (DFS(j)) {
                return true;
            }
        }
        visited[i] = 2;
        res[index++] = i;
        return false;
    }
}

class Solution {

    private List<List<Integer>> graph = new ArrayList<>();
    private int[] indegree;
    private int[] res;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Kahn, also like BFS
        indegree = new int[numCourses];
        res = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            ++indegree[pre[0]];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                q.offerLast(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.pollFirst();
            res[index++] = node;
            for (int i : graph.get(node)) {
                --indegree[i];
                if (indegree[i] == 0) {
                    q.offerLast(i);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return res;
    }
}
