class Solution {
    public long minimumRemoval(int[] arr) {

        Arrays.sort(arr);

        List<Long> ll = new ArrayList<>();

        ll.add((long) arr[0]);

        for (int i = 1; i < arr.length; i++) {
            ll.add(ll.get(ll.size() - 1) + (long) arr[i]);
        }

        long op = Long.MAX_VALUE;

        for (int i = 0; i < ll.size(); i++) {

            long toMake0 = (i == 0) ? 0 : ll.get(i - 1);

            long toEqual = ll.get(ll.size() - 1) - toMake0;

            long finals = (long) arr[i] * (ll.size() - i);

            long val = toEqual - finals;

            op = Math.min(op, toMake0 + val);
        }

        return op;
    }
}