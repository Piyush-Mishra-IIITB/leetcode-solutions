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
    public int numComponents(ListNode head, int[] arr) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
              hm.put(arr[i],1);
        }
        ListNode temp=head;
        int components=0;
        while(temp.next!=null){
             if(hm.containsKey(temp.val)){
                hm.remove(temp.val);
                while(temp.next!=null && hm.containsKey(temp.next.val)){
                    hm.remove(temp.next.val);
                    temp=temp.next;
                    
                }
                components++;
             }else{
                temp=temp.next;
             }
        }
        return components+hm.size();
    }
}