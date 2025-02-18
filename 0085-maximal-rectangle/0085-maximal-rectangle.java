class Solution {

    public int maxRect(int[] mat)
    {
        Stack<Integer> st = new Stack<Integer>();
        int n = mat.length;
        int area = 0;

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && mat[st.peek()] >= mat[i])
            {
                int right = i;
                int element = mat[st.peek()];
                st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int curr = (element)*(right - left - 1);
                area = Math.max(curr,area);
            }

            st.push(i);
        }

        while(!st.isEmpty())
        {
            int right = n;
            int element = mat[st.peek()];
            st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            int curr = (element)*(right - left - 1);
            area = Math.max(area,curr);
        }

        return area;

    }


    public int maximalRectangle(char[][] matrix) {

        // T.C -> O(N*M) + O(2*M)
        // S.C -> O(N*M) + O(N)
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] psm = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                psm[i][j] = (int)(matrix[i][j] - '0');
            }
        }

        // prefix operation on psm

        for(int j = 0; j < m; j++)
        {
            int prefix = 0;
            for(int i = 0; i < n; i++)
            {
                if(psm[i][j] == 0)
                {
                    prefix = 0;
                }
                else
                {
                    prefix++;
                }

                psm[i][j] = prefix;
            }
        }

        // for(int i = 0; i < n; i++)
        // {
        //     for(int j = 0; j < m; j++)
        //     {
        //         System.out.print(psm[i][j] + " ");
        //     }

        //     System.out.println();
        // }

    

        int maxo = 0;

        for(int i = 0; i < n; i++)
        {
            int area = maxRect(psm[i]);
            maxo = Math.max(maxo,area);
        }

        return maxo;
        
    }
}