class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Brute Force
        int[] arr = new int[nums1.length];
        int len = 0;
        
        for(int i = 0; i < nums1.length; i++)
        {
            int ind = -1;
            
            for(int j = 0; j < nums2.length; j++)
            {
                if(nums1[i] == nums2[j])
                {
                    ind = j;
                    break;
                }
            }
            
            int nxtGreater = -1;

            for(int j = ind + 1; j < nums2.length; j++)
            {
                if(nums2[ind] < nums2[j])
                {
                    nxtGreater = nums2[j];
                    break;
                }
            }

            arr[len] = nxtGreater;
            len++;

        }

        return arr;
    }
}