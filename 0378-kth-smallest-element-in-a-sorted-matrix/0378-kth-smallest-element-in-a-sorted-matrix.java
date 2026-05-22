class Solution {

    public int kthSmallest(int[][] arr, int k) {

        int n = arr.length;

        int smallest = arr[0][0];
        int largest = arr[n-1][n-1];

        int output = largest;

        while(smallest <= largest) {

            int mid =
                smallest + (largest - smallest) / 2;

            int count = helper(mid, arr);

            if(count >= k) {

                output = mid;
                largest = mid - 1;
            }
            else {
                smallest = mid + 1;
            }
        }

        return output;
    }

    public int helper(int target, int[][] arr) {

        int n = arr.length;

        int r = n - 1;
        int c = 0;

        int count = 0;

        while(r >= 0 && c < n) {

            if(arr[r][c] > target) {
                r--;
            }
            else {
                count += r + 1;
                c++;
            }
        }

        return count;
    }
}