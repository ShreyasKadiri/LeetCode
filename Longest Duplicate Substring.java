class Solution {
    public String longestDupSubstring(String S) {
        int[] nums = new int[S.length()];
        
        for(int i=0; i<S.length(); i++) 
            nums[i] =(int)S.charAt(i)-(int)'a';
        int a=26;
        long mod=(long)Math.pow(2,32);
        int l=1;
        int r=S.length();
        int mid;
        
        while(l!=r) {
            mid=l+ (r-l)/2;
            if(rabinKarp(mid,a,mod,S.length(),nums)!=-1)
                l=mid+1;
            else 
                r=mid;
        }
        
        int low=rabinKarp(l-1, a, mod, S.length(), nums);
        return low!= -1? S.substring(low,low+l-1) : "";
    }
    
    
    public int rabinKarp(int mid, int a, long mod, int length, int[] nums) {
        long h=0;
        for(int i=0; i<mid; i++)
            h=(h*a +nums[i])%mod;
        HashSet<Long> set = new HashSet<Long>();
        set.add(h);
        long hash=1;
        
        for(int i=1; i<=mid; i++)
            hash=(hash*a) % mod;
        
        for(int start=1; start<length-mid+1; start++){
            h=(h*a- nums[start-1]* hash %mod + mod) %mod;
            h=(h + nums[start+mid-1])%mod;
            if(set.contains(h)) 
                return start;
            set.add(h);
        }
        return-1;
    }
}
