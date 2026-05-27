class Solution {

    public class pair{

        int first;
        int second;

        public pair(int first, int second){

            this.first = first;   
            this.second = second; 
        }
    }

    public int[] dailyTemperatures(int[] arr) {
        Stack<pair> ss = new Stack<>();
        int n = arr.length;
        int ans[] = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int curr = arr[i];
            while(!ss.isEmpty() && ss.peek().first <= curr){
                ss.pop();
            }
            if(ss.isEmpty()){
                ans[i] = 0;
            }
            else{
                ans[i] = ss.peek().second - i;
            }
            ss.push(new pair(curr, i));
        }
        return ans;
    }
}