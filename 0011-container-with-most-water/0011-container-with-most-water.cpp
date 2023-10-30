class Solution {
public:
    int maxArea(vector<int>& height) {
        // vector<int>vec;
        // set<int>st;
        // int max = 0;
        // long area = 0;
        // for(int i = 0; i < height.size(); i++)
        // {
        //     for(int j = i + 1; j < height.size(); j++)
        //     {
        //         if(height[i] <= height[j])
        //         {
        //              area = (height[i]*(j-i));
        //             // vec.emplace_back(area);
        //             // st.insert(area);
        //         }
        //         else
        //         {
        //              area = (height[j]*(j - i));
        //             // vec.emplace_back(area);
        //             // st.insert(area);
        //         }

        //         if(area >= max)
        //         {
        //             max = area;
        //         }
        //     }
        // }

        // sort(vec.begin(),vec.end());
        // auto itr = vec.rbegin();
        // auto itr = st.rbegin();
        // return (*itr);
        // return max;

        int l = 0;
        int r = (height.size() - 1);
        int area = 0;
        int max = 0;
        while(l < r)
        {
            if(height[l] < height[r])
            {
                area = height[l]*(r-l);
                l++;
            }
            else
            {
                area = height[r]*(r-l);
                r--;
            }

            if(area >= max)
            {
                max = area;
            }

        }

        return max;

        
    }
};