public class Solution {
    public boolean isNumber(String s) {
        try {
            String number = s.trim();
            if (number.length()==0 || (number.charAt(number.length()-1)!='.'
                                && 
                (number.charAt(number.length()-1)-'0'<0 || number.charAt(number.length()-1)-'0' >9 ))) {
                return false;
            }
            double n = Double.parseDouble(number);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
