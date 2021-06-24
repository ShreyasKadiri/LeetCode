class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder("");
        String[] words = s.split(" ");
        for (String word : words){
            result.append((new StringBuilder(word)).reverse()).append(" ");
        }
        return result.toString().trim();
    }
}
