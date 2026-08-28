class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < arr.length - 2; j++) {

                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                for (int k = j + 1; k < arr.length - 1; k++) {

                    if (k > j + 1 && arr[k] == arr[k - 1]) {
                        continue;
                    }

                    int start = k + 1;
                    int end = arr.length - 1;

                    while (start <= end) {

                        int mid = start + (end - start) / 2;

                        long val = (long) arr[i] 
                                 + arr[j] 
                                 + arr[k] 
                                 + arr[mid];

                        if (val == target) {

                            List<Integer> ll = new ArrayList<>();

                            ll.add(arr[i]);
                            ll.add(arr[j]);
                            ll.add(arr[k]);
                            ll.add(arr[mid]);

                            ans.add(ll);

                            break;

                        } else if (val > target) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                }
            }
        }

        return ans;
    }
}