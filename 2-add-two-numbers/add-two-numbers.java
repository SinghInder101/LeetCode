/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return helper(l1, l2, carry);

    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                ListNode Last = new ListNode(carry);
                return Last;
            }
            return null;
        }
        if (l1 != null && l2 != null) {
            int presentAns = l1.val + l2.val + carry;
            if (presentAns >= 10) {
                ListNode curr = new ListNode();
                curr.val = presentAns - 10;
                ListNode ans = helper(l1.next, l2.next, 1);
                 if(ans == null){
                    return curr;
                }
                curr.next = ans;
                return curr;
            } else {
                ListNode curr =  new ListNode();
                curr.val = presentAns;
                ListNode ans = helper(l1.next, l2.next, 0);
                if(ans == null){
                    return curr;
                }
                curr.next = ans;
                return curr;
            }
        }
        if (l1 == null || l2 == null) {
            int presentAns;
            if (l1 == null) {
                presentAns = l2.val + carry;
                if (presentAns >= 10) {
                    ListNode curr = new ListNode();
                    curr.val = presentAns - 10;
                    ListNode ans = helper(l1, l2.next, 1);
                     if(ans == null){
                    return curr;
                }
                    curr.next = ans;
                    return curr;

                } else {
                    ListNode curr = new ListNode();
                    curr.val = presentAns;
                    ListNode ans = helper(l1, l2.next, 0);
                     if(ans == null){
                    return curr;
                }
                    curr.next = ans;
                    return curr;
                }

            }
            if (l2 == null) {
                 presentAns = l1.val + carry;
                if (presentAns >= 10) {
                    ListNode curr= new ListNode();
                    curr.val = presentAns - 10;
                    ListNode ans = helper(l1.next, l2, 1);
                     if(ans == null){
                    return curr;
                }
                    curr.next = ans;
                    return curr;
                } else {
                    ListNode curr =new ListNode();
                    curr.val = presentAns;
                    ListNode ans = helper(l1.next, l2, 0);
                     if(ans == null){
                    return curr;
                }
                    curr.next = ans;
                    return curr;
                }

            }

        }
        return null;
    }
}
