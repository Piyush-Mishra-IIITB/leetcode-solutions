class Solution {
    public int[] sortArray(int[] arr) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ans.add(arr[i]);
        }
        List<Integer> h=helper(ans);
        int ae[]=new int[ans.size()];
        for(int i=0;i<h.size();i++){
            ae[i]=h.get(i);
        }
        return ae;
    }
    public List<Integer> helper(List<Integer>ans){
        if(ans.size()==0){
            return new ArrayList<>();
        }
        if(ans.size()==1){
            List<Integer>h=new ArrayList<>();
            h.add(ans.get(0));
            return h;
        }
        int middle=ans.size()/2;
        List<Integer>left=new ArrayList<>();
        List<Integer>right=new ArrayList<>();
        for(int i=0;i<middle;i++){
            left.add(ans.get(i));
        }
        for(int i=middle;i<ans.size();i++){
            right.add(ans.get(i));
        }
        List<Integer>l=helper(left);
        List<Integer>r=helper(right);
        return solve(l,r);
    }
    public List<Integer> solve(List<Integer>l,List<Integer>r){
        List<Integer>ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<l.size()&& j<r.size()){
            if(l.get(i)<=r.get(j)){
                ans.add(l.get(i));
                i++;
            }
            else{
                ans.add(r.get(j));
                j++;
            }
        }
        while(i<l.size()){
            ans.add(l.get(i));
                i++;
        }
        while(j<r.size()){
            ans.add(r.get(j));
                j++;
        }
        return ans;
    }
}