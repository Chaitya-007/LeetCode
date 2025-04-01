class Solution {

    public int fact(int num)
    {
        int fact = 1;

        for(int cnt = 1; cnt <= num; cnt++)
        {
            fact *= cnt;
        }

        return fact;
    }


    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            list.add(i);
        }

        k = k - 1;
        int temp = n - 1;
        int div = fact(temp);
        int ind = k/div;

        while(sb.length() != n)
        {

            Integer num = list.get(ind);
            list.remove(ind);
            // ans.add(num);
            sb.append(num);

            k = k%div;
            temp--;
            div = fact(temp);
            ind = k/div;
            
        }

        return sb.toString();
        
    }
}