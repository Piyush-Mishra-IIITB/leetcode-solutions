class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i=0;
        int j=0;
        HashMap<Integer,List<Integer>>hm=new HashMap<>();
        while(i<nums1.length && j<nums2.length){
            int id1=nums1[i][0];
            int val1=nums1[i][1];
            int id2=nums2[j][0];
            int val2=nums2[j][1];
            if(id1==id2){
               hm.putIfAbsent(id1,new ArrayList<>());
               List<Integer>ll=hm.get(id1);
               ll.add(val1+val2);
               hm.put(id1,ll);
               i++;
               j++;
            }
            else if(id1>id2){
                hm.putIfAbsent(id2,new ArrayList<>());
                List<Integer>ll=hm.get(id2);
               ll.add(val2);
               hm.put(id2,ll);
               j++;
            }else{
                 hm.putIfAbsent(id1,new ArrayList<>());
                 List<Integer>ll=hm.get(id1);
               ll.add(val1);
               hm.put(id1,ll);
               i++;
            }
            
        }
        while(i<nums1.length){
              int id1=nums1[i][0];
              int val1=nums1[i][1];
              hm.putIfAbsent(id1,new ArrayList<>());
                 List<Integer>ll=hm.get(id1);
               ll.add(val1);
               hm.put(id1,ll);
               i++;
        }
        while(j<nums2.length){
              int id1=nums2[j][0];
              int val1=nums2[j][1];
              hm.putIfAbsent(id1,new ArrayList<>());
                List<Integer>ll=hm.get(id1);
               ll.add(val1);
               hm.put(id1,ll);
               j++;
        }
        int ans[][]=new int[hm.size()][2];
        int p=0;
        for(Integer it:hm.keySet()){
            ans[p][0]=it;
            ans[p][1]=hm.get(it).get(0);
            p++;
        }
        Arrays.sort(ans,(a,b)->a[0]-b[0]);
        return ans;
    }
}