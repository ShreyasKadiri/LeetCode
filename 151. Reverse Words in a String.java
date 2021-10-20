class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().replaceAll(" +", " ").split(" ");
        StringBuilder reverse = new StringBuilder("");
        for(int i=words.length-1; i>=0; i--){
             reverse.append(words[i] + " ");
        }  
        return reverse.toString().trim();
    }
}
