/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // vector<int>vec;

        // while(list1 != nullptr)
        // {
        //     vec.emplace_back(list1->val);
        //     list1 = list1->next;
        // }

        // while(list2 != nullptr)
        // {
        //     vec.emplace_back(list2->val);
        //     list2 = list2->next;
        // }

        // sort(vec.begin(),vec.end());
        
        // ListNode *t = nullptr;
        // ListNode *head = nullptr;

        // for(int i = 0; i < vec.size(); i++)
        // {
        //     if(head == nullptr)
        //     {
        //         t = new ListNode(vec[i]);
        //         head = t;
        //     }
        //     else
        //     {
        //         ListNode *p = new ListNode(vec[i]);
        //         t->next = p;
        //         t = t->next;
        //         p = nullptr;
        //     }
        // }

        // return head;
        
        // if list 1 is empty return list 2 simply
        if(list1 == nullptr)
        {
            return list2;
        }

        // if list 2 is empty return list 1 simply
        if(list2 == nullptr)
        {
            return list1;
        }

        ListNode *ptr = list1;
        if(list1->val < list2->val)
        {
            list1 = list1->next;
        }
        else
        {
            ptr = list2;
            list2 = list2->next;
        }
        ListNode *curr = ptr;

        while(list1 and list2)
        {
            if(list1->val < list2->val)
            {
                curr->next = list1;
                list1 = list1->next;
            }
            else
            {
                curr->next = list2;
                list2 = list2->next;
            }
            curr = curr->next;
        }

        if(!list1)
        {
            curr->next = list2;
        }
        else
        {
            curr->next = list1;
        }

        return ptr;
    }
};