class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
        while(sum>0 && num>0){
            if(sum>=9){
                sb.append('9');
                sum-=9;
                num--;
            }
            else if(sum==8){
                sb.append('8');
                sum-=8;
                num--;
            }
           else if(sum==7){
                sb.append('7');
                sum-=7;
                num--;
            }
           else if(sum==6){
                sb.append('6');
                sum-=6;
                num--;
            }
            else if(sum==5){
                sb.append('5');
                sum-=5;
                num--;
            }
            else if(sum==4){
                sb.append('4');
                sum-=4;
                num--;
            }
            else if(sum==3){
                sb.append('3');
                sum-=3;
                num--;
            }
           else  if(sum==2){
                sb.append('2');
                sum-=2;
                num--;
            }
           else if(sum==1){
                sb.append('1');
                sum-=1;
                num--;
            }
        }
        if(sum==0 && num>0){
            for(int i=0;i<num;i++){
                sb.append('0');
            }
        }
        if(sum>0 && num<=0){
            return "";
        }
        return sb.toString();
    }
}