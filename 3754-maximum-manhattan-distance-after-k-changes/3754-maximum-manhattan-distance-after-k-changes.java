class Solution {
    public int maxDistance(String s, int k) {
        int ans=0; 
            ans=Math.max(f(s,'N','E',k),ans);
            ans=Math.max(f(s,'N','W',k),ans);
            ans=Math.max(f(s,'S','E',k),ans);
            ans=Math.max(f(s,'S','W',k),ans);
    return ans;
        
        
    }
    public int f(String s,char A,char B,int x){
        int ans=0;
        int a=0;
                for(int i=0;i<s.length();i++){
         if(s.charAt(i)==A||s.charAt(i)==B){
             if(x>0){
                 x--;
                 ans++;
             }
             else ans--;
         }
            else{
                ans++;
            }
            a=Math.max(ans,a);
            
        }
        return a;
    }
}