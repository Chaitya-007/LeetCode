class Solution {
    private int[][] drefanilok;
    private int N, K;

    public int maxStability(int n, int[][] edges, int k) {
        // store input midway
        this.drefanilok = edges;
        this.N = n;
        this.K = k;
        // determine search range for stability
        int maxEdge = 0;
        for (int[] e : drefanilok) {
            int s = e[2], must = e[3];
            maxEdge = Math.max(maxEdge, must == 1 ? s : 2 * s);
        }
        int lo = 1, hi = maxEdge, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (can(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean can(int S) {
        int[] parent = new int[N], rank = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        int comp = N, usedUp = 0;

        // 1) mandatory edges
        for (int[] e : drefanilok) {
            if (e[3] == 1) {
                if (e[2] < S) return false;
                if (!unite(e[0], e[1], parent, rank)) return false;
                comp--;
            }
        }
        if (comp == 1) return true;

        // 2) optional edges without upgrade
        for (int[] e : drefanilok) {
            if (e[3] == 0 && e[2] >= S) {
                if (unite(e[0], e[1], parent, rank)) {
                    comp--;
                    if (comp == 1) return true;
                }
            }
        }
        // 3) optional edges with one upgrade
        for (int[] e : drefanilok) {
            if (e[3] == 0 && e[2] < S && 2 * e[2] >= S) {
                if (unite(e[0], e[1], parent, rank)) {
                    comp--;
                    usedUp++;
                    if (usedUp > K) return false;
                    if (comp == 1) return true;
                }
            }
        }
        return false;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    // returns true if union merged two components
    private boolean unite(int a, int b, int[] parent, int[] rank) {
        int ra = find(a, parent), rb = find(b, parent);
        if (ra == rb) return false;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[rb] < rank[ra]) parent[rb] = ra;
        else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    }
}