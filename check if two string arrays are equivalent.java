class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       return formString(word1).equals(formString(word2));
    }
    
    
    public String formString(String array[]){
        StringBuilder sb = new StringBuilder("");
        for(String word : array){
            sb.append(word);
        }
        return sb.toString();
    } 
}
