class Solution {
    public int minDistance(String word1, String word2) {
        return word2.length() - longestCommonSubsequence(word1, word2);
    }
    
    
    public int longestCommonSubsequence(String word1, String word2){
        int lcs[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<word1.length(); i++){
            for(int j=0; j<word2.length(); j++){
                if(i==0 || j==0){
                    lcs[i][j] = 0;
                }
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    lcs[i][j] = 1+ lcs[i-1][j];
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        return lcs[word1.length()-1][word2.length()-1];
    }
}
