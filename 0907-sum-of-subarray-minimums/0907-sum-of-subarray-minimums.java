class Solution {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        Stack<Integer> psm = new Stack<>();

        Stack<Integer> nsm = new Stack<>();

        int ps[] = new int[n];

        int ns[] = new int[n];

        for(int i = 0; i < n; i++){

            while(!psm.isEmpty() &&
                  arr[psm.peek()] > arr[i]){

                psm.pop();
            }

            if(psm.isEmpty()){

                ps[i] = -1;
            }
            else{

                ps[i] = psm.peek();
            }

            psm.push(i);
        }
        for(int i = n - 1; i >= 0; i--){

            while(!nsm.isEmpty() &&
                  arr[nsm.peek()] >= arr[i]){

                nsm.pop();
            }

            if(nsm.isEmpty()){

                ns[i] = n;
            }
            else{

                ns[i] = nsm.peek();
            }

            nsm.push(i);
        }

        long sum = 0;

        int mod = 1000000007;

        for(int i = 0; i < n; i++){

            long left = i - ps[i];

            long right = ns[i] - i;

            sum = (sum +
                  (arr[i] * left * right) % mod)
                  % mod;
        }

        return (int)sum;
    }
}