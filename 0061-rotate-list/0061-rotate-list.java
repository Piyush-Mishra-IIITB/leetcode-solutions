class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head== null || head.next==null){
            return head;
        }
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int m=k%length;
        if(m==0){
            return head;
        }
        while(m!=0){
            ListNode temp2=head;
            while(temp2.next.next!=null){
                temp2=temp2.next;
            }
            ListNode last=temp2.next;
            temp2.next=null;
            last.next=head;
            head=last;
            m--;
        }
        return head;
        
    }
}