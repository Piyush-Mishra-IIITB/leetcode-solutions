
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode temp1=l1;
      ListNode temp2=l2;
      int carry=0;
      ListNode temp3=new ListNode(-1);
      ListNode temp4=temp3;
      while(temp1!=null && temp2!=null){
        int a=temp1.val;
        int b=temp2.val;
        int c=(a+b+carry)%10;
        temp4.next=new ListNode(c);
        temp4=temp4.next;
        carry=(a+b+carry)/10;
        temp1=temp1.next;
        temp2=temp2.next;
      }
    while(temp1!=null){
        int a=temp1.val;
        
        int c=(a+carry)%10;
        temp4.next=new ListNode(c);
        temp4=temp4.next;
        carry=(a+carry)/10;
        temp1=temp1.next;
    }
    while(temp2!=null){
        int b=temp2.val;
        int c=(b+carry)%10;
        temp4.next=new ListNode(c);
        temp4=temp4.next;
        carry=(b+carry)/10;
        temp2=temp2.next;
    }
    if(carry!=0){
        temp4.next=new ListNode(carry);
    }
    return temp3.next;
}}
