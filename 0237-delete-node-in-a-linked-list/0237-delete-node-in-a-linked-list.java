/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode ptr = node.next;
        while(ptr.next != null)
        {
            int temp = node.val;
            node.val = ptr.val;
            ptr.val = temp;
            node = ptr;
            ptr = ptr.next;
        }

        int temp = node.val;
            node.val = ptr.val;
            ptr.val = temp;

            node.next = null;
            
    }
}