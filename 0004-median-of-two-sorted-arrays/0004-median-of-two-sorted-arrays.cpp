class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // Uniion of two sorted arrays
        // Using STL
        // set<int> st = {nums1.begin(),nums1.end()};

        // st.insert(nums2.begin(),nums2.end());

        // vector<int> vec(st.begin(),st.end());

// *********************************************************************
        // Union Of Two Sorted Arrays
        // int i = 0;
        // int j = 0;

        // vector<int> vec;
        // int n1 = nums1.size();
        // int n2 = nums2.size();

        // while(i < n1 && j < n2)
        // {
        //     if(nums1[i] <= nums[j])
        //     {
        //         if(vec.size() == 0 || vec.back() != nums1[i])
        //         {
        //             vec.emplace_back(nums1[i]);
        //         }

        //         i++;
        //     }
        //     else
        //     {
        //         if(vec.size() == 0 || vec.back() != nums2[j])
        //         {
        //             vec.emplace_back(nums2[j]);
        //         }
        //         j++;
        //     }
        // }

        // while(i < n1)
        // {
        //     if(vec.size() == 0 || vec.back() != nums1[i])
        //         {
        //             vec.emplace_back(nums1[i]);
        //         }

        //         i++;
        // }

        // while( j < n2)
        // {
        //     if(vec.size() == 0 || vec.back() != nums2[j])
        //         {
        //             vec.emplace_back(nums2[j]);
        //         }
        //         j++;
        // }

        // int n = vec.size();

        // if()

        // *******************************************************
         int n = nums1.size();
        int m = nums2.size();

        // Merge the arrays into a single sorted array.
        vector<int> merged;
        for (int i = 0; i < n; i++) {
            merged.push_back(nums1[i]);
        }
        for (int i = 0; i < m; i++) {
            merged.push_back(nums2[i]);
        }

        // Sort the merged array.
        sort(merged.begin(), merged.end());

        // Calculate the total number of elements in the merged array.
        int total = merged.size();

        if (total % 2 == 1) {
            // If the total number of elements is odd, return the middle element as the median.
            return static_cast<double>(merged[total / 2]);
        } else {
            // If the total number of elements is even, calculate the average of the two middle elements as the median.
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return (static_cast<double>(middle1) + static_cast<double>(middle2)) / 2.0;
        }
    }
};