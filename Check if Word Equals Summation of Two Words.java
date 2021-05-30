class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String num1 = "";
        String num2 = "";
        String num3 = "";
        
        for(char c : firstWord.toCharArray()){
            num1+=(c - 'a');
        }
        
        for(char c : secondWord.toCharArray()){
            num2+=(c - 'a');
        }

        for(char c : targetWord.toCharArray()){
            num3+=(c - 'a');
        }
        
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int n3 = Integer.parseInt(num3);
        
        return n1 + n2 == n3;
    }
}
