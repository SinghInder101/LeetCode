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
        if(head == null || head.next == null){
            return head;
        }

        ListNode tempHead= head;
        
        for(int i = 1; i<k ;i++){
            tempHead = tempHead.next;
            if(tempHead == null){
                return head;
            }

        }
         ListNode reverseKGroup = reverseKGroup(tempHead.next,k);
         tempHead.next = null;
         ListNode currReverse = reverseList(head);
         head.next = reverseKGroup;
         return currReverse;
         
    }
     public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode rev = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return rev;
    }
}