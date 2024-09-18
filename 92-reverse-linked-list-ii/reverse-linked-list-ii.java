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
    public ListNode reverseBetween(ListNode head, int left, int right) {

      
      
      if(left <=1 && right>1){
         ListNode tempHead = reverseBetween(head.next,left-1,right-1);
         ListNode end = head.next.next;
         head.next.next =head;
         head.next = end;
         return tempHead;


      }
      if(left == 0 && right==1){
        return head;
      }
      if(left>1 && right >1){
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
      }
      return head;
       
        
    }
}