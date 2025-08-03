class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;

        int i = 1;
        int cnt = 0;
        int maxo = weight[0];

        while(i < n)
            {
                if(weight[i] < maxo)
                {
                    cnt++;

                    if(i + 1 != n)
                    {
                        maxo = weight[i + 1];
                    }

                    i += 2;
                }
                else
                {
                    maxo = Math.max(maxo, weight[i]);
                    i++;
                }
            }

        return cnt;
    }
}