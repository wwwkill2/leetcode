class Solution {
    
    private List<List<Integer>> res = new ArrayList<>();
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> xyDiff = new HashSet<>();
    private Set<Integer> xySum = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        dfs(n, new ArrayList<>());
        return output();
    }
    
    private List<List<String>> output() {
        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            List<String> list = new ArrayList<>();
            List<Integer> r = res.get(i);
            for (int j : r) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < r.size(); k++) {
                    sb.append(k == j ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            output.add(list);
        }
        return output;
    }
    
    private void dfs(int n, List<Integer> tmp) {
        // terminator
        if (tmp.size() == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // process current level
        int level = tmp.size();
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !xyDiff.contains(level-j) && !xySum.contains(level+j)) {
                tmp.add(j);
                col.add(j);
                xyDiff.add(level-j);
                xySum.add(level+j);
                // drill down
                dfs(n, tmp);
                // reset states
                tmp.remove(tmp.size()-1);
                col.remove(j);
                xyDiff.remove(level-j);
                xySum.remove(level+j);
            }
        }
    }
}
