class Solution {
public int titleToNumber(String s) {
        int total=s.charAt(0)-'A'+1;
        for (int i=1; i<s.length(); i++) {
            int value=s.charAt(i)-'A'+1;
            total=total*26+value;
        }
        return total;
    }   
}
