class Solution {
    public int myAtoi(String s) {
        int i = 0;
        long result = 0;
        boolean isPositive = true;
        
        if(s == null || s.length() == 0) {
            return (int) result;
        }
        
        while(s.charAt(i) == ' ') {
            if(i == s.length() -1) {
                 return (int) result;
            }
            i++;
        }
        
        if(s.charAt(i) == '-') {
             if(i == s.length() -1) {
                 return (int) result;
             }
            isPositive = false;
            i++;
        } else if(s.charAt(i) == '+') {
            if(i == s.length() -1) {
                 return (int) result;
            }
            i++;
        }
        
        while(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = (result * 10) + s.charAt(i) - '0';
            i++;
            
            if(result > Integer.MAX_VALUE && isPositive) {
                result = Integer.MAX_VALUE;
                return (int) result;
            } else if(result > Integer.MAX_VALUE && !isPositive){
                result = Integer.MIN_VALUE;
                return (int) result;
            }
            
            if(i == s.length()) {
                 break;
            }
        }
        
        if(!isPositive){
            result = -1 * result;
        }
        return (int) result;
    }
}
