class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return new ArrayList<>();

        HashMap<Character,String> hm = new HashMap<>();

        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

        List<String> ans = new ArrayList<>();
        helper(0, hm, new StringBuilder(), digits, ans);
        return ans;
    }

    public void helper(int ind, HashMap<Character,String> hm,StringBuilder sb, String ss, List<String> ans){

        if(ind == ss.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = hm.get(ss.charAt(ind));

        for(int i = 0; i < letters.length(); i++){
            sb.append(letters.charAt(i));
            helper(ind + 1, hm, sb, ss, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}