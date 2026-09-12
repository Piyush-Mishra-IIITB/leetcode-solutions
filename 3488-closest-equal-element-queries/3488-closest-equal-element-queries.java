class Solution {
    public List<Integer> solveQueries(int[] arr, int[] ask) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.putIfAbsent(arr[i], new ArrayList<>());
            hm.get(arr[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for (int curr : ask) {

            List<Integer> ll = hm.get(arr[curr]);

            if (ll.size() == 1) {
                ans.add(-1);
                continue;
            }
            int low = lower(ll, curr);
            int high = higher(ll, curr);

            int prev;
            int next;
            if (low == -1)
                prev = ll.get(ll.size() - 1);
            else
                prev = ll.get(low);
            if (high == -1)
                next = ll.get(0);
            else
                next = ll.get(high);

            int d1 = Math.abs(curr - prev);
            d1 = Math.min(d1, n - d1);

            int d2 = Math.abs(curr - next);
            d2 = Math.min(d2, n - d2);

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
    public int lower(List<Integer> ll, int curr) {
        int start = 0;
        int end = ll.size() - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (ll.get(mid) < curr) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
    public int higher(List<Integer> ll, int curr) {
        int start = 0;
        int end = ll.size() - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (ll.get(mid) > curr) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}