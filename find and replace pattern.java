class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
       List<String> result  = new ArrayList<String>();
        boolean flag = true;
        for(String word : words){
            int patternFrequency[] = new int[26];
            int currentString[] = new int[26];
            for(int i=0; i<word.length(); i++){
                if(currentString[word.charAt(i) - 'a']!= patternFrequency[pattern.charAt(i) - 'a']){
                    flag = false;
                    break;
                }else {
                    currentString[word.charAt(i) - 'a'] = i+1;
                    patternFrequency[pattern.charAt(i) - 'a'] = i+1;
                }
            }
            if(flag == true){
                result.add(word);
            }
        }
        return result;
    }
}
