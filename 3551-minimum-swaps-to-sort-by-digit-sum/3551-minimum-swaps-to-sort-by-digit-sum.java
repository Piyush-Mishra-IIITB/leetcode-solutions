


class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int val = helper(curr);
            hm.putIfAbsent(val, new ArrayList<>());
            hm.get(val).add(curr);
            arr[i] = val;
        }

        HashMap<Integer, List<Integer>> hm2 = new HashMap<>();

        for (Integer it : hm.keySet()) {
            List<Integer> ll = hm.get(it);
            Collections.sort(ll);
            hm2.put(it, ll);
        }

        Arrays.sort(arr);
        int arr2[] = new int[n];

        for (int i = 0; i < n; i++) {
            int c = arr[i];
            List<Integer> ll = hm2.get(c);
            arr2[i] = ll.get(0);
            ll.remove(0);

            if (ll.isEmpty()) {
                hm2.remove(c);
            }
        }

        // Minimum changes: replace mismatch counting with cycle detection
        HashMap<Integer, Queue<Integer>> targetPositions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetPositions.putIfAbsent(arr2[i], new LinkedList<>());
            targetPositions.get(arr2[i]).offer(i);
        }

        int pos[] = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = targetPositions.get(nums[i]).poll();
        }

        boolean visited[] = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int j = i;
            int cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = pos[j];
                cycle++;
            }

            if (cycle > 0) {
                swaps += cycle - 1;
            }
        }

        return swaps;
    }

    public int helper(int curr) {
        int val = 0;
        while (curr > 0) {
            val += curr % 10;
            curr /= 10;
        }
        return val;
    }
}
