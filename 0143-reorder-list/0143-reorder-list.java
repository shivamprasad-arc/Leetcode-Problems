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
        //step 1 : find mid
        ListNode mid = findMid(head);

        //Step 2 : break the node into two parts and reverse the second half
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode leftHead = head;
        ListNode rightHead = prev;
        ListNode nextLeft, nextRight;
        while(leftHead != null && rightHead != null){
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead =  nextRight;
        }
        
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}