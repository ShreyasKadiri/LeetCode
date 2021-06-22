class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        int wordFrequency[] = new int[26];
        int stringFrequency[] = new int[26];
        int length = 0;
        
        for(char c : s.toCharArray()){
            stringFrequency[c - 'a']++;
        }
        
        for(String word : words){
            for(char c : word.toCharArray()){
                wordFrequency[c - 'a']++;
            }
            
            for(char c : word.toCharArray()){
                if(wordFrequency[c - 'a'] != stringFrequency[c - 'a']){
                    break;
                }else {
                    count++;
                }
            }   
        }
        return count;
    }
}
