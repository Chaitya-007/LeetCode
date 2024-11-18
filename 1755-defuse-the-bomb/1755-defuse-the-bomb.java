class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k == 0)
        {
            for(int i = 0; i < code.length; i++)
            {
                code[i] = 0;
            }

            return code;
        }

        if(k > 0)
        {
            int n = code.length;
            int[] temp = new int[n];
            for(int i = 0; i < code.length; i++)
            {
                int sum = 0;
                for(int cnt = 1; cnt <= k; cnt++)
                {
                    sum += code[(i + cnt)%n];
                }

                temp[i] = sum;
            }

            return temp;
        }

        int n = code.length;
        int[] temp = new int[n];

        for(int i = 0; i < code.length; i++)
        {
            int l = i - 1;
            int sum = 0;
            for(int cnt = 1; cnt <= Math.abs(k); cnt++)
            {
                if(l < 0)
                {
                    l = n - 1;
                }

                sum += (code[l]);
                l--;
            }
            temp[i] = sum;
        }

        return temp;

    }
}