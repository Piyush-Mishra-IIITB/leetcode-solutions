class Solution {
    public String simplifyPath(String s) {
        Stack<String>ss=new Stack<>();
        String arr[]=s.split("/");
        for(int i=0;i<arr.length;i++){
            String a=arr[i];
            if(a.equals(".") || a.equals("")){
                continue;
            }
            if(a.equals("..")){
                if(!ss.isEmpty()){
                  ss.pop();
                  }
            }
            else{
                ss.push(a);
            }
        }
        StringBuilder sb=new StringBuilder();
       for(int i=0;i<ss.size();i++){
        sb.append("/");
        sb.append(ss.get(i));
       }
       if(sb.length()==0){
        return "/";
       }
        return sb.toString();
    }
}