class Solution {

    int n, k;
    int[][] tree;
    int[] prod;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value % k);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.cnt[x];
        }

        return ans;
    }

    class Node {
        int product;
        int[] cnt;

        Node(int product, int[] cnt) {
            this.product = product;
            this.cnt = cnt;
        }
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            prod[node] = nums[l] % k;

            for (int i = 0; i < k; i++) {
                tree[node][i] = 0;
            }

            tree[node][prod[node]] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node);
    }

    void update(int node, int l, int r, int idx, int value) {
        if (l == r) {
            prod[node] = value;

            for (int i = 0; i < k; i++) {
                tree[node][i] = 0;
            }

            tree[node][value] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, value);
        }

        merge(node);
    }

    void merge(int node) {
        int left = node * 2;
        int right = node * 2 + 1;

        prod[node] = (prod[left] * prod[right]) % k;

        for (int i = 0; i < k; i++) {
            tree[node][i] = tree[left][i];

            // Prefixes which extend into the right child
            for (int j = 0; j < k; j++) {
                if ((prod[left] * j) % k == i) {
                    tree[node][i] += tree[right][j];
                }
            }
        }
    }

    Node query(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            return new Node(prod[node], tree[node].clone());
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        int[] cnt = new int[k];

        // Prefixes entirely inside left
        for (int i = 0; i < k; i++) {
            cnt[i] += left.cnt[i];
        }

        // Prefixes that extend from left into right
        for (int j = 0; j < k; j++) {
            int rem = (left.product * j) % k;
            cnt[rem] += right.cnt[j];
        }

        int product = (left.product * right.product) % k;

        return new Node(product, cnt);
    }
}