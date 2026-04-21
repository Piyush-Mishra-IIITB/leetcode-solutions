class Solution {
    public int countCharacters(String[] words, String s) {
        
        int i=0;
        int n=words.length;
        int n2=s.length();
        int ans=0;
        while(i<n){
            String v=words[i];
            StringBuilder var=new StringBuilder(s);
            int l=var.length();
            for(int j=0;j<v.length();j++){
                for(int k=0;k<var.length();k++){
                    if(v.charAt(j)==var.charAt(k)){
                        var.deleteCharAt(k);
                        break;
                    }
                }
                
            }
            if(var.length()==l-v.length()){
                ans+=v.length();
            }
            i++;
        }
        return ans;
    }
}