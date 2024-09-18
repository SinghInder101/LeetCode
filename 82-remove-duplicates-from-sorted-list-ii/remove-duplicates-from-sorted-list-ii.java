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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val == head.next.val){
        ListNode temp = deleteDuplicates(head.next);
        if(temp == null){
            return null;
        }
        if(head.val != temp.val){
            return temp;
        }
        return temp.next;

        }
        else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
     
     
        
    }
}