class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
     List<String> list = new ArrayList<String>();

     for(String str : words)
     {
        String[] arr = str.split("[" + separator + "]");
        for(String temp : arr)
        {
            if(temp.length() != 0)
            {
                list.add(temp);
            }
        }
      }

      return list;

    }
}