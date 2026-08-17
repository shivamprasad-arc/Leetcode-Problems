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
    public ListNode mergeKLists(ListNode[] lists) {
        //Create Min heap : smallest element at the top
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Add all node values into the heap
        for(ListNode head: lists){
            //Go to the every node of current linked list
            while(head != null){
                pq.add(head.val);
                head = head.next;
            }
        }

        // Build a single sorted list
        ListNode dummy = new ListNode(0);  
        ListNode temp = dummy;
        // remove elements to the heap and in the last of the linked list
        while(!pq.isEmpty()){
            temp.next = new ListNode(pq.remove());
            temp = temp.next;
        }
        // return sorted list removing dummy node (0)
        return dummy.next;
    }
}