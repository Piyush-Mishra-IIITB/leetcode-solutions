/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       int arr[]=new int[2];
          arr[0]=-1;
            arr[1]=-1;
        if(head.next.next==null){
            
            return arr;
        }
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode next=head.next.next;
        List<Integer>ll=new ArrayList<>();
        int length=1;
        while(next!=null){
            length++;
            int a=prev.val;
            int b=curr.val;
            int c=next.val;
            if(b>a && b>c){
               System.out.println(length);
                ll.add(length);
            }
            if(b<a && b<c){
                System.out.println(length);
                ll.add(length);
            }
            prev=curr;
            curr=next;
            next=next.next;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<ll.size();i++){       
            min=Math.min(min,ll.get(i)-ll.get(i-1));
        }
        if(ll.size()==0 || ll.size()==1){
            return arr;
        }
        max=ll.get(ll.size()-1)-ll.get(0);
        arr[0]=min;
        arr[1]=max;
        return arr;
    }
}