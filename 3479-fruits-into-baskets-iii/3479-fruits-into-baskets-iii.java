class Solution {

    int[] segment;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        segment = new int[4 * n];

        build(0, 0, n - 1, baskets);

        int ans = 0;

        for (int fruit : fruits) {

            int idx = find(0, 0, n - 1, fruit);

            if (idx == -1) {
                ans++;
            } else {
                update(0, 0, n - 1, idx, 0);
            }
        }

        return ans;
    }

    void build(int ind, int left, int right, int[] baskets) {

        if (left == right) {
            segment[ind] = baskets[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(2 * ind + 1, left, mid, baskets);
        build(2 * ind + 2, mid + 1, right, baskets);

        segment[ind] = Math.max(segment[2 * ind + 1], segment[2 * ind + 2]);
    }

    int find(int ind, int left, int right, int fruit) {

        if (segment[ind] < fruit)
            return -1;

        if (left == right)
            return left;

        int mid = left + (right - left) / 2;

        if (segment[2 * ind + 1] >= fruit)
            return find(2 * ind + 1, left, mid, fruit);

        return find(2 * ind + 2, mid + 1, right, fruit);
    }

    void update(int ind, int left, int right, int pos, int val) {

        if (left == right) {
            segment[ind] = val;
            return;
        }

        int mid = left + (right - left) / 2;

        if (pos <= mid)
            update(2 * ind + 1, left, mid, pos, val);
        else
            update(2 * ind + 2, mid + 1, right, pos, val);

        segment[ind] = Math.max(segment[2 * ind + 1], segment[2 * ind + 2]);
    }
}