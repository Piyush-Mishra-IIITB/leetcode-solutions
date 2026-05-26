import java.util.*;

class Solution {

    public int[] findEvenNumbers(int[] arr) {

        Arrays.sort(arr);

        List<Integer> ll = new ArrayList<>();

        boolean vis[] = new boolean[arr.length];

        HashSet<Integer> set = new HashSet<>();

        helper(arr, vis, ll, set);

        int ans[] = new int[set.size()];

        int index = 0;

        for(int x : set){
            ans[index++] = x;
        }

        Arrays.sort(ans);

        return ans;
    }

    public void helper(int arr[],
                       boolean vis[],
                       List<Integer> ll,
                       HashSet<Integer> set){

        if(ll.size() == 3){

            if(ll.get(2) % 2 == 0){

                int num =
                    ll.get(0) * 100 +
                    ll.get(1) * 10 +
                    ll.get(2);

                set.add(num);
            }

            return;
        }

        for(int i = 0; i < arr.length; i++){

            if(vis[i] == false){

                // leading zero not allowed
                if(ll.size() == 0 && arr[i] == 0){
                    continue;
                }

                vis[i] = true;

                ll.add(arr[i]);

                helper(arr, vis, ll, set);

                ll.remove(ll.size() - 1);

                vis[i] = false;
            }
        }
    }
}