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
    // Time complexity: O(N)
    // Space complexity: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        // if list is empty or only having one node then return the head node
        if(head == null || head.next == null){
            return head;
        }
        // create a temproary node for traversing the list
        ListNode temp = head;

        // continue until reaches the last node 
        while(temp != null && temp.next != null){
            // if current node data == next node data then remove the duplicates
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;  // removing duplicate
            }else{
                temp = temp.next;  // if no duplicate node is present then go to the next node
            }
        }
        return head;   // return the original head of linked list
    }
}