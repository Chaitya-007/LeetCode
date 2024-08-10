/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode collisionPoint(ListNode small, ListNode large, int diff)
    {
        while(diff > 0)
        {
            diff--;
            large = large.next;
        }

        while(small != large)
        {
            small = small.next;
            large = large.next;
        }

        return small; // or return large
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Naive Approach
        // T.C -> O(n1 * logN) + O(n2 * logN)
        // S.C -> O(N1) or O(N2)
        // if(headA == null || headB == null)
        // {
        //     return null;
        // }

        // HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();

        // ListNode ptra = headA;
        // ListNode ptrb = headB;

        // while(ptra != null)
        // {
        //     map.put(ptra,1);
        //     ptra = ptra.next;
        // }

        // while(ptrb != null)
        // {
        //     if(map.containsKey(ptrb))
        //     {
        //         return ptrb;
        //     }
        //     ptrb = ptrb.next;
        // }

        // return null;

        // Using Two Approach
        // T.C -> O(N1) + O(N2) + O(n2 - N1) + O(N2 , whichever is small let's consider N2 as small)
        // if(headA == null || headB == null)
        // {
        //     return null;
        // }
        // int n1 = 0;
        // int n2 = 0;
        // ListNode tempA = headA;
        // ListNode tempB = headB;

        // while(tempA != null)
        // {
        //     n1++;
        //     tempA = tempA.next;
        // }

        // while(tempB != null)
        // {
        //     n2++;
        //     tempB = tempB.next;
        // }

        // tempA = headA; // Set the pointers to head again
        // tempB = headB; // Set the pointers to head again

        // if(n1 < n2)
        // {
        //     return collisionPoint(tempA,tempB,n2 - n1);
        // }

        // return collisionPoint(tempB,tempA,n1 - n2);

        // Optimal Solution
        // T.C -> O(N1 + N2)
        // S.C -> O(1)
        // if(headA == null || headB == null)
        // {
        //     return null;
        // }

        // ListNode t1 = headA;
        // ListNode t2 = headB;

        // while(t1 != t2)
        // {
        //     t1 = t1.next;
        //     t2 = t2.next;

        //     if(t1 == t2) // this also holds true for t1 == null && t2 == null
        //     {
        //         return t1;
        //     }

        //     if(t1 == null)
        //     {
        //         t1 = headB;
        //     }
        //     if(t2 == null)
        //     {
        //         t2 = headA;
        //     }

        // }

        // return t1;


        if(headA == null || headB == null)
        {
            return null;
        }

        ListNode t1 = headA;
        ListNode t2 = headB;

        while(t1 != t2)
        {
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2)
            {
                return t1;
            }

            if(t1 == null) t1 = headA;
            if(t2 == null) t2 = headB;
        }

        return t1;
    }
}