/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Brute Force
        if(head == null)
        {
            return null;
        }

        HashMap<ListNode, Integer> map = new HashMap<ListNode,Integer>();
        int ind = 0;

        ListNode temp = head;
        while(temp != null)
        {
            if(map.containsKey(temp))
            {
                return temp;
            }
            map.put(temp,ind);
            ind++;
            temp = temp.next;
        }

        return null;


    }
}