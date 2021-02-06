class Solution {
    public int minimumLength(String s) {
        int low=0;
        int high=s.length() - 1; 
        while(low<high && s.charAt(low) == s.charAt(high)) {
            char ch = s.charAt(low);
            while(low<=high && s.charAt(low) == ch)
                low++;
            
            while(high>=low && s.charAt(high) == ch)
                high--;
        }
        return low > high ? 0 : high - low + 1;
    }
}
