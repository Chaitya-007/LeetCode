class Pair
{
    int nums;
    int ind;

    public Pair(int nums_, int ind_)
    {
        this.nums = nums_;
        this.ind = ind_;
    }

    public int getNums()
    {
        return nums;
    }

    public int getInd()
    {
        return ind;
    }
}

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();

        int n = nums1.length;

        List<Pair> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
         list.add(new Pair(nums1[i],i));   
        }

        Comparator<Pair> comp = (p1, p2) -> 
        {
            return Integer.compare(p1.getNums(),p2.getNums());
        };

        Collections.sort(list,comp);

        long[] ans = new long[n];

        List<Integer> pending = new ArrayList<>();

        long sum = 0;
        int sz = 0;

        for(int i = 0; i < n; i++)
        {
            int ind = list.get(i).getInd();
            int value = nums2[ind];
            ans[ind] = sum;
            pending.add(value);

            if(i < n - 1 && list.get(i).getNums() == list.get(i+1).getNums())
            {
                continue;
            }


            for(Integer num : pending)
            {
                if(sz < k)
                {
                    sum += num;
                    multiset.put(num, multiset.getOrDefault(num,0) + 1);
                    sz++;
                }
                else 
                {
                    Map.Entry<Integer, Integer> firstEntry = multiset.firstEntry();
                    Integer fkey = firstEntry.getKey();
                    Integer fval = firstEntry.getValue();
                if(fkey < num)
                {


                    
                        multiset.put(fkey, multiset.get(fkey) - 1);
                        if(multiset.get(fkey) == 0)
                        {
                            multiset.remove(fkey);
                        }

                    sum = sum - fkey;
                    sum = sum + num;
                    multiset.put(num,multiset.getOrDefault(num,0) + 1);
                }
                }
            }

            pending.clear();
        }

        return ans;
        
    }
}