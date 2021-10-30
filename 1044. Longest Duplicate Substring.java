class Solution {
    public String longestDupSubstring(String s) {
        int low = 1;
        int high = s.length()-1;
        String result = "";
        while(low <= high){
            int mid = low + (high-low)/2;
            String str=rabinKarp(s,mid);
            if(str.length()!=0){
                result=str;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }
    
    private String rabinKarp(String s,int len){
        Set<Long> set=new HashSet<>();
        long h=hash(s.substring(0,len));
        set.add(h);
        long pow=1;
        for(int l=1;l<len;l++) pow*=31;
        
        for(int i=1;i<=s.length()-len;i++){
            h=nextHash(pow,h,s.charAt(i-1),s.charAt(i+len-1));
            if(set.contains(h)){
                return s.substring(i,i+len);
            }
            set.add(h);
        }
        return "";
    }
    
   private long nextHash(long pow,long hash,char low,char high){
       return (hash - low*pow)*31 + high;
   }  
    
    private long hash(String s) {
		long hash = 0;
        long mul=1;
		for (int i = s.length()-1; i >=0; i--) {
			hash += s.charAt(i)*mul;
            mul*=31;
		}
		return hash;
	}   
}
