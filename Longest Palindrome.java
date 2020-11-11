class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128]; 
        int ans=0;
        boolean oddIncluded=false; 
        
        for(char ch : s.toCharArray())
        count[ch]++;
        
        for(int i=0;i<count.length;i++){
            if(count[i]==0)
             continue;
            if(count[i]%2 == 0) 
            ans+= count[i]; 
            
            else{
                if(!oddIncluded){ 
                ans+=count[i]; 
                oddIncluded=true;
                }  
                else{
                ans += count[i]-1; 
            }
          }
        }  
        return ans;
    }
}
