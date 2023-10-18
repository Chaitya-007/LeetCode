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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
    {
        
        // // vector<int>v1;
        // // while(l1 != nullptr)
        // // {
        // //     v1.emplace_back(l1->val);
        // //     l1 = l1->next;
        // // }
        // // vector<int>v2;

        // // while(l2 != nullptr)
        // // {
        // //     v2.emplace_back(l2->val);
        // // }
        
        // // long long num1 = 0;
        // // long long num2 = 0;

        // // reverse(v1.begin(),v2.end());
        // // reverse(v2.begin(),v2.end());

        // // for(int i = 0; i < v1.size() ; i++)
        // // {
        // //     num1 = v1[i] + (num1*10);
        // // }

        // // for(int i = 0; i < v2.size(); i++)
        // // {
        // //     num2 = v2[i] + (num2*10);
        // // }

        // // long long result = num1 + num2;

        // // vector<int> v3;
        // // int rem = 0;

        // // while(result>0)
        // // {
        // //     rem = (result%10);
        // //     v3.emplace_back(rem);
        // //     result = result/10;
        // // }

        // // reverse(v3.begin(),v3.end());

        // // int i = 0;
        // // struct ListNode *t = nullptr;
        // // struct ListNode *q = nullptr;
        // // struct ListNode *head = nullptr;

        // // while(i<v3.size())
        // // {
        // //     if(i == 0)
        // //     {
        // //         t = new ListNode(v3[i]);
        // //         head = t;
        // //         i++;
        // //     }

        // //     else
        // //     {
        // //         q = new ListNode(v3[i]);
        // //         t->next = q;
        // //         t = t->next;
        // //         q = nullptr;
        // //         i++;
        // //     }
        // // }

        // // return head;

        // if( (l1->val == 0 and l1->next == nullptr) and (l2->val == 0 and l2->next == nullptr) )
        // {
        //     struct ListNode *t = new ListNode(0);
        //     return t;
        // }

        // long long num1 = 0;
        // long long num2 = 0;

        // while(l1 != nullptr)
        // {
        //     num1 = (l1->val) + (num1*10);
        //     l1 = l1->next;
        // }

        // // cout<<num1<<endl;

        // while(l2 != nullptr)
        // {
        //     num2 = (l2->val) + (num2*10);
        //     l2 = l2->next;
        // }

        // // cout<<num2<<endl;

        // long long num1_rev = 0;
        // long long num2_rev = 0;
        // int rem = 0;

        // while(num1>0)
        // {
        //     rem = (num1%10);
        //     num1 = num1/10;
        //     num1_rev = rem + (num1_rev*10);
        // }



        // while(num2>0)
        // {
        //     rem = (num2%10);
        //     num2 = num2/10;
        //     num2_rev = rem + (num2_rev*10);
        // }

        // long long result = num1_rev + num2_rev;
        // struct ListNode *t = nullptr;
        // struct ListNode *q = nullptr;
        // struct ListNode *head = nullptr;
        // int flag = 0;

        // while(result>0)
        // {
        //     if(flag == 0)
        //     {
        //         t = new ListNode((result%10));
        //         result = result/10;
        //         head = t;
        //         flag = 1;
        //     }

        //     else
        //     {
        //         q = new ListNode((result%10));
        //         result = result/10;
        //         t->next = q;
        //         t = t->next;
        //         q = nullptr;
        //     }
        // }

        // // t = head;
        // // while(t != nullptr)
        // // {
        // //     cout<<t->val<<" ";
        // //     t = t->next;
        // // }

        // return head;

        struct ListNode *head = nullptr;
        struct ListNode *temp = nullptr;
        int carry = 0;

        while(l1 != nullptr || l2 != nullptr || carry )
        {
            int sum = 0;

            if(l1 != nullptr)
            {
                sum += (l1->val);
                l1 = l1->next;
            }

            if(l2 != nullptr)
            {
                sum += (l2->val);
                l2 = l2->next;
            }

            sum += carry;
            carry = sum/10;
            struct ListNode *newnode = new ListNode((sum%10));

            if(head == nullptr)
            {
                head = temp = newnode;
            }

            else
            {
                temp->next = newnode;
                temp = temp->next;
            }
        }

        return head;
        
    }
};