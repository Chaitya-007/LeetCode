class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {

        // Optimal Solution
        int n1 = nums1.size();
        int n2 = nums2.size();

        if(n1 > n2) { return findMedianSortedArrays(nums2,nums1);};

        int low = 0; 
        int high = n1;
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;

        while(low <= high)
        {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = INT_MIN, l2 = INT_MIN;
            int r1 = INT_MAX, r2 = INT_MAX;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1)
            {
                if(n%2 == 1)
                {
                    return max(l1,l2);
                }
                else
                {
                    return ((double)(max(l1,l2)) + (double)(min(r1,r2))) / 2.0;
                }
            }
            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;


        // Using STL
        // vector<int> vec;
        // vec = nums1;
        // vec.insert(vec.begin(),nums2.begin(),nums2.end());

        // sort(vec.begin(),vec.end());

        // int n = vec.size();
        // double ans = 0;

        // if(n%2 == 1)
        // {
        //     // return static_cast<double>(vec[n/2]);
        //     ans = vec[n/2];
        // }
        // else
        // {
        // int middle1 = vec[(n/2) - 1];
        // int middle2 = vec[(n/2)];

        // return (static_cast<double>(middle1) +
        // static_cast<double>(middle2))/ 2.0; ans = ( (double)(vec[(n/2) - 1])
        // + (double) (vec[(n/2)]) ) / 2.0;
        // }

        // return ans;

        // *********************************************************************

        // int i = 0;
        // int j = 0;

        // vector<int> vec;
        // int n1 = nums1.size();
        // int n2 = nums2.size();

        // while(i < n1 && j < n2)
        // {
        //     if(nums1[i] <= nums2[j])
        //     {
        //             vec.emplace_back(nums1[i]);
        //         i++;
        //     }
        //     else
        //     {
        //             vec.emplace_back(nums2[j]);
        //         j++;
        //     }
        // }

        // while(i < n1)
        // {

        //             vec.emplace_back(nums1[i]);
        //         i++;
        // }

        // while( j < n2)
        // {

        //             vec.emplace_back(nums2[j]);
        //         j++;
        // }

        // int n = vec.size();
        // double ans = 0;

        // if(n%2 == 1)
        // {
        // return static_cast<double>(vec[n/2]);
        //     ans = vec[n/2];
        // }
        // else
        // {
        // int middle1 = vec[(n/2) - 1];
        // int middle2 = vec[(n/2)];

        // return (static_cast<double>(middle1) +
        // static_cast<double>(middle2))/ 2.0;
        //     ans = ( (double)(vec[(n/2) - 1]) + (double) (vec[(n/2)]) ) / 2.0;
        // }

        // return ans;

        // ***********************************************************************
        // T.C -> O(m + n)
        // S.C -> O(1)
        // int i = 0;
        // int j = 0;

        // vector<int> vec;
        // int n1 = nums1.size();
        // int n2 = nums2.size();

        // int n = n1 + n2;

        // int cnt = 0;
        // int ind1 = (n/2) - 1;
        // int ind2 = (n/2);
        // int el1 = -1;
        // int el2 = -1;


        // while (i < n1 && j < n2) {
        //     if (nums1[i] <= nums2[j]) {

        //        if(cnt == ind1)
        //        {
        //         el1 = nums1[i];
        //        }

        //         if(cnt == ind2)
        //         {
        //             el2= nums1[i];
        //         }

        //         i++;
        //         cnt++;

        //     } else {
                
        //         if(cnt == ind1)
        //         {
        //             el1 = nums2[j];
        //         }

        //         if(cnt == ind2)
        //         {
        //             el2 = nums2[j];
        //         }

        //         j++;
        //         cnt++;
        //     }
        // }

        // while (i < n1) {

        //    if(cnt == ind1)
        //        {
        //         el1 = nums1[i];
        //        }

        //         if(cnt == ind2)
        //         {
        //             el2= nums1[i];
        //         }

        //         i++;
        //         cnt++;
        // }

        // while (j < n2) {

        //    if(cnt == ind1)
        //         {
        //             el1 = nums2[j];
        //         }

        //         if(cnt == ind2)
        //         {
        //             el2 = nums2[j];
        //         }

        //         j++;
        //         cnt++;
            
        // }

        // if(n%2 == 1)
        // {
        //     return (double)(el2);
        // }

        // return ( (double) (el1) + (double) (el2) )/ 2.0;

    }
};