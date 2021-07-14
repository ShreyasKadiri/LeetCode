class Solution {
    public String customSortString(String order, String str) {
        int frequency[] = new int[26];
        for(char c : str.toCharArray()){
            frequency[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder("");
        for(char c : order.toCharArray()){
            while(frequency[c - 'a'] > 0){
                sb.append(c);
                frequency[c - 'a']--;
            }
        }
        
        for(int i=0; i<26; i++){
            int currentCharacterCount = frequency[i];
            while(currentCharacterCount > 0){
                sb.append((char)(i+'a'));
                currentCharacterCount--;
            }
        }
        return sb.toString();
    }
}
