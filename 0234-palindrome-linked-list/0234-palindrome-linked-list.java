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

    public static boolean checkPallindrome(ArrayList<Integer> list)
    {
        int n = list.size();
        
        int left = 0;
        int right = n - 1;

        while(left < right)
        {
            if(list.get(left) != list.get(right))
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        // Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        ListNode ptr = head;
        while(ptr != null)
        {
            list.add(ptr.val);
            ptr = ptr.next;
        }


        if(checkPallindrome(list))
        {
            return true;
        }

        return false;
        
    }
}