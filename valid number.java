class Solution 
{
    public boolean isNumber(String s) 
    {
        s = s.trim();
        boolean eSeen = false;
        boolean numSeen = false;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false;
            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        
        return numSeen;
    }
}
