class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n < 2) {
            return 0;
        }
        int[][] arr = new int[n * (n - 1) / 2][];
        int idx = 0;
        for (int i = 0; i < n - 1; ++i) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; ++j) {
                int[] p2 = points[j];
                arr[idx++] = new int[]{i, j, Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])};
            }
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);
        int mst = 0;
        UF uf = new UF(n);
        for (int[] item : arr) {
            int p1 = item[0];
            int p2 = item[1];
            int edge = item[2];
            if (uf.isConnected(p1, p2)) {
                continue;
            }
            uf.union(p1, p2);
            mst += edge;
            if (uf.count() == 1) {
                return mst;
            }
        }
        return mst;
    }
}

class UF {

    private int[] parent;
    private int count;
    private int[] size;

    public UF(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        --count;
    }

    public boolean isConnected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }

}
