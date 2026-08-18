class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int sum[]=new int[words.length];
         if(helper(words[0])){
            sum[0]=1;
         }else{
            sum[0]=0;
         }
        for(int i=1;i<words.length;i++){
            if(helper(words[i])){
                sum[i]=1+sum[i-1];
            }else{
                sum[i]=sum[i-1];
            }
        }
        for(int i=0;i<sum.length;i++){
            System.out.println(sum[i]);
        }
       int ans[]=new int[queries.length];
       int p=0;
         for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
            int u=a[0];
            int v=a[1];
            int op=sum[v];
            if(u>0){
               op-=sum[u-1];
            }
            ans[p]=op;
            p++;
         }
        return ans;
    }
    public boolean helper(String s){
        char first=s.charAt(0);
        char last=s.charAt(s.length()-1);
        boolean flag1=false;
        boolean flag2=false;
        if(first=='a' || first=='e' || first=='i' || first=='o' ||first=='u' ){
           flag1=true;
        }
        if(last=='a' || last=='e' || last=='i' || last=='o' ||last=='u' ){
           flag2=true;
        }
        return flag1 && flag2;
    }
}