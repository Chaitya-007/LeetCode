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
        

        for(int i = 1; i <= n; i++)
        {
            list.add(i);
        }

        k = k - 1;


        int facto = fact(n - 1);

        while(true)
        {
            sb.append(String.valueOf( list.get( k/facto ) ) );
            list.remove(k/facto);
            if(list.size() == 0)
            break;

            k = k%facto;
            facto = facto / list.size();

            
        }

        

        return sb.toString();
        
    }
}