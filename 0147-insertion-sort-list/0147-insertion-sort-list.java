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

import java.util.*;
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp=head;
        int counter=0;
        while(temp!=null){
            counter++;
            temp=temp.next;
        }
        int arr[]=new int [counter];
        int a=0;
        ListNode temp1=head;
        while(temp1!=null){
            arr[a]=temp1.val;
            temp1=temp1.next;
            a++;
        }
        Arrays.sort(arr);
        return arrayToLinkedList(arr);
    }
    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}