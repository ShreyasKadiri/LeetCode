class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int values[] = new int[2];
        for(int i=0; i<s.length(); i++){
            for(int j=1+i; j<=s.length(); j++){
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


//Linear
class Solution {
    public int countBinarySubstrings(String s) {
        int currentLength = 1;
        int previousLength = 0;
        int count = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                currentLength++;
            }else {
            previousLength = currentLength;
            currentLength = 1;
        }
        if (previousLength >= currentLength){
            count++;
        }
    }
    return count;    
    }
}
