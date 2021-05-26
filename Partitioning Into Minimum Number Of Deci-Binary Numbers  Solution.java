class Solution {
    public int minPartitions(String n) {
        int maximumDigit = Integer.MIN_VALUE;
        for(char digit : n.toCharArray()){
            maximumDigit = Math.max(maximumDigit,Integer.parseInt(String.valueOf(digit)));
        }
        return maximumDigit;
    }
}
