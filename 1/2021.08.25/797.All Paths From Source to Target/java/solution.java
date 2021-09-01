class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // BFS
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> level = new HashSet<>();
        level.add(new ArrayList<>(Arrays.asList(0)));
        while (!level.isEmpty()) {
            Set<List<Integer>> nextLevel = new HashSet<>();
            for (List<Integer> path : level) {
                for (int node : graph[path.get(path.size() - 1)]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(node);
                    if (node == graph.length - 1) {
                        res.add(newPath);
                    } else {
                        nextLevel.add(newPath);
                    }
                }
            }
            level = nextLevel;
        }
        return res;
    }
}
