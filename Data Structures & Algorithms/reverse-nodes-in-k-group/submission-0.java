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
          // Check if at least k nodes exist
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Fewer than k nodes left
        if (count < k) {
            return head;
        }

        // Reverse first k nodes
        ListNode prev = null;
        curr = head;
        count = 0;

        while (count < k) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }

        // head is now the tail of the reversed group
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this group
        return prev;
    }
}
