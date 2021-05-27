class Solution {
    public int maxProduct(String[] words) {
        int maximumProduct = 0;
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if(checkCommonCharacters(words[i], words[j])){
                    maximumProduct = Math.max(maximumProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maximumProduct;
    }
    

    public boolean checkCommonCharacters(String word1, String word2){
        char characters[] = new char[26];
        //For the first word
        for(char c : word1.toCharArray()){
            if(characters[c - 'a'] == 0){
                characters[c - 'a']++;
            }
        }
        
        //For the second word
        for(char c : word2.toCharArray()){
            if(characters[c - 'a'] == 1){
                return false;
            }
        }
        return true;
    }
}
