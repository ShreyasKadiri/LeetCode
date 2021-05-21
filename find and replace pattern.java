class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
       List<String> result  = new ArrayList<String>();
        for(String word : words){
            int patternFrequency[] = new int[26];
            int currentString[] = new int[26];
            boolean match = true;
            for(int i=0; i<word.length(); i++){
                if(currentString[word.charAt(i) - 'a']!= patternFrequency[pattern.charAt(i) - 'a']){
                    match = false;
                    break;
                }else {
                    currentString[word.charAt(i) - 'a'] = i+1;
                    patternFrequency[pattern.charAt(i) - 'a'] = i+1;
                }
            }
            if(match == true){
                result.add(word);
            }
        }
        return result;
    }
}
