class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        List<String> noEqual = new ArrayList<>();
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            } else {
                noEqual.add(s);
            }
        }
        for (String s : noEqual) {
            if (uf.connected(s.charAt(0) - 'a', s.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
