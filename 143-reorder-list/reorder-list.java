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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return; // No need to reorder if the list is empty or has only one node
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Slow pointer moves one step
            fast = fast.next.next;  // Fast pointer moves two steps
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Break the link between the two halves

        // Step 3: Merge the two halves alternately
        ListNode firstHalf = head;
        mergeLists(firstHalf, secondHalf);
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next; // Store the next node
            head.next = prev;              // Reverse the current node's pointer
            prev = head;                   // Move prev to the current node
            head = nextNode;               // Move to the next node
        }
        return prev; // Return the new head of the reversed list
    }

    // Helper method to merge two lists alternately
    private void mergeLists(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2; // Merge node from second half after l1
            l2.next = l1Next; // Link l2 to the next node in the first half

            l1 = l1Next; // Move to the next node in the first half
            l2 = l2Next; // Move to the next node in the second half
        }
    }
}
