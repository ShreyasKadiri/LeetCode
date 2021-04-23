class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int values[] = new int[2];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                String currentString = s.substring(i,j);
                values = countZeroesOnes(currentString);
                if(values[0] == values[1]){
                    count++;
                }
            }
        }
        return count;
    }
    
    public int[] countZeroesOnes(String currentString){
        int ones = 0;
        for(char c : currentString.toCharArray()){
            if(c == '1'){
                ones+=1;
            }
        }
        return new int[]{ones, currentString.length()-ones};
    }
}
