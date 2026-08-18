class Solution {
    public int nextGreaterElement(int n) {
        int x=n;
        int newno=0;
        StringBuilder sb=new StringBuilder();
        while(x>0){
            sb.append(x%10);
            x=x/10;
        }
        int i=sb.length()-2;
        int j=sb.length()-1;
        boolean update=false;
        sb.reverse();
        int ind=-1;
        while(i>=0){
            if(sb.charAt(i)-'0'<sb.charAt(j)-'0'){
                update=true;
                ind=i;
                break;
            }
            else{
                i--;
                j--;
            }
        }
        if(ind==-1){
            return -1;
        }
     char atPosition=sb.charAt(ind);
     char arr[]=new char [sb.length()-(ind+1)];
     int l=0;
     for(int p=ind+1;p<sb.length();p++){
           arr[l]=sb.charAt(p);
           l++;
     }
     
     Arrays.sort(arr);
     // just greter ellem then the ellem at index
     char justGreater=atPosition;
     for(int m=0;m<arr.length;m++){
        char c=arr[m];
        if(justGreater-'0'<c-'0'){
            sb.setCharAt(ind,c);
            arr[m]=atPosition;
            break;
        }
     }
    //   for(int k=0;k<sb.length();k++){
    //     System.out.println(sb.charAt(k));
    //   }
     StringBuilder sbn=new StringBuilder();
      for(int m=0;m<arr.length;m++){
        char now=arr[m];
         sbn.append(now);
      }
    //   for(int m=0;m<sbn.length();m++){
    //     char now=sbn.charAt(m);
    //     System.out.println(now);
    //   }
      StringBuilder output=new StringBuilder();;
      for(int z=0;z<=ind;z++){
        output.append(sb.charAt(z));
      }
      System.out.println("initlength" +output.length());
    //    for(int k=0;k<output.length();k++){
    //     System.out.println(output.charAt(k));
    //   }
      Arrays.sort(arr);
      for(int z=0;z<arr.length;z++){
        System.out.println(arr[z]);
        output.append(arr[z]);
      }

      long mlp=0;
      System.out.println("length" +output.length());
      for(int m=0;m<output.length();m++){
        
        char curr=output.charAt(m);
        System.out.println("variable "+ curr);
        int val=curr-'0';
        System.out.println(val);
        mlp=mlp*10+val;
        if(mlp>Integer.MAX_VALUE){
            return -1;
        }
      }
      return (int)mlp;
   }
}