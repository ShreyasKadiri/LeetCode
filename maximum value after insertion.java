class Solution {
    public String maxValue(String n, int x) {
        boolean isNegative = false;
        if(n.charAt(0) == '-'){
            isNegative = true;
            n = n.substring(1);
        }
        
        for(int i=0; i<n.length(); i++){
            int currentDigit = n.charAt(i) - '0';
            if(!isNegative && currentDigit<x || isNegative && currentDigit>x){
                return (isNegative? "-": "") + n.substring(0, i) + x + n.substring(i);
            }
        }
        return (isNegative? "-": "") + n + x;
    }
}
