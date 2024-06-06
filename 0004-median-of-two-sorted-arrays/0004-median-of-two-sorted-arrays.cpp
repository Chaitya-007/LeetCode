class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // Uniion of two sorted arrays

// *********************************************************************
        // Union Of Two Sorted Arrays
        int i = 0;
        int j = 0;

        vector<int> vec;
        int n1 = nums1.size();
        int n2 = nums2.size();

        while(i < n1 && j < n2)
        {
            if(nums1[i] <= nums2[j])
            {
                    vec.emplace_back(nums1[i]);
                i++;
            }
            else
            {
                    vec.emplace_back(nums2[j]);
                j++;
            }
        }

        while(i < n1)
        {

                    vec.emplace_back(nums1[i]);
                i++;
        }

        while( j < n2)
        {

                    vec.emplace_back(nums2[j]);
                j++;
        }

        int n = vec.size();
        double ans = 0;

        if(n%2 == 1)
        {
            // return static_cast<double>(vec[n/2]);
            ans = vec[n/2];
        }
        else
        {
            // int middle1 = vec[(n/2) - 1];
            // int middle2 = vec[(n/2)];

            // return (static_cast<double>(middle1) + static_cast<double>(middle2))/ 2.0;
            ans = ( (double)(vec[(n/2) - 1]) + (double) (vec[(n/2)]) ) / 2.0;
        }

        return ans;

    }
};