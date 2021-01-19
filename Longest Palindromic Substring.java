class Solution {
    public boolean isPalindrome(String s) {
        if(s=="" || s.length()==0){
            return true;
        }
        
        int low= 0;
        int high = s.length()-1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    
    
    public String longestPalindrome(String s){
       String result = "";
        for(int i=0; i<s.length(); i++){
            for(int j=s.length()-1; j>i; j--){
                String palindrome = s.substring(i, j+1);
                if(palindrome.length() > result.length() && isPalindrome(palindrome)){
                    result = palindrome;
                    break;
                }
            }
        }
        
        return result.length()>0 ? result: ""+s.charAt(0);
    }
}
