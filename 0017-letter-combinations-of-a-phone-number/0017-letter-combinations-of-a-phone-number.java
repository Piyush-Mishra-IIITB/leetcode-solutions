class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>hm=new HashMap<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        StringBuilder sb=new StringBuilder();
        List<String>ll=new ArrayList<>();
        helper(0,digits,sb,ll,hm);
        return ll;

    }
    public void helper(int ind,String digit,StringBuilder sb,List<String>ll,HashMap<Integer,String>hm){
        if(sb.length()==digit.length()){
            String toAdded=sb.toString();
            ll.add(toAdded);
            return;
        }
        char curr=digit.charAt(ind);
        String now=hm.get(curr-'0');
        for(int i=0;i<now.length();i++){
          int init=sb.length();
           sb.append(now.charAt(i));
           helper(ind+1,digit,sb,ll,hm);
           sb.setLength(init);
        }
    }
}