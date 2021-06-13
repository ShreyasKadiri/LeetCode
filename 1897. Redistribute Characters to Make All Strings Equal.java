class Solution {
    public boolean makeEqual(String[] words) {
        char frequency[] = new char[26];
        for(String word : words){
            for(char c : word.toCharArray()){
                frequency[c- 'a']++;
            }
        }
        
        for(int i=0; i<26; i++){
            if(frequency[i]%words.length!=0){
                return false;
            }
        }
        return true;
    }
}
