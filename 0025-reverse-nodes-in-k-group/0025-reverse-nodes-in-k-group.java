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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int arr[]=new int[length];
        ListNode t=head;
        int p=0;
        while(t!=null){
            arr[p]=t.val;
            p++;
            t=t.next;
        }
        int i=0;
        int j=k-1;
        while(j<arr.length){
            helper(arr,i,j);
            i=j+1;
            j=j+k;
        }
        ListNode newone =new ListNode(arr[0]);
        ListNode ans=newone;
        for(int l=1;l<arr.length;l++){
           ListNode h =new ListNode(arr[l]);
          newone.next=h;
          newone=newone.next;
        }   
        return ans;
 }
    public void helper(int arr[],int i,int j){
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}