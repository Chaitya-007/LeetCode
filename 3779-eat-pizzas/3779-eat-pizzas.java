class Solution {
    public long maxWeight(int[] pizzas) {
        
        Arrays.sort(pizzas);

        int n = pizzas.length;

        int days = n/4;
        int evenDay = days/2;
        int oddDay = days - evenDay;

        long ans = 0;
        long ind = n;

       for(int cnt = 1; cnt <= oddDay; cnt++)
       {

           ans += (long)(pizzas[(int)(n-cnt)]);
       }

       int lastInd = (n - oddDay);

       for(int cnt = 1; cnt <= evenDay; cnt++)
       {
           ans += (long)(pizzas[lastInd - 2]);
           lastInd -= 2;

       }

        return ans;
        
    }
}