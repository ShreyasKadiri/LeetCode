class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        else if(s.length() == 1 || isPalindrome(s)) return 1;
        return 2;
    }
    
    public boolean isPalindrome(String s){
        if(s.length() <= 1) return true;
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}
