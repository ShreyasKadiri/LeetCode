class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String word :  words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        int totalWordsLength = words.length;
        int eachWordLength = words[0].length();
        
        for(int i=0; i<=s.length()-totalWordsLength*eachWordLength; i++){
            HashMap<String, Integer> seen = new HashMap<String, Integer>();
            for(int j=0; j<totalWordsLength; j++){
                int wordIndex = i+ j*eachWordLength;
                String currentWord = s.substring(wordIndex, wordIndex+eachWordLength);
                if(!map.containsKey(currentWord)){
                    break;
                }
                seen.put(currentWord, seen.getOrDefault(currentWord,0)+1);
                
            if(seen.get(currentWord) > map.getOrDefault(currentWord,0)){
                break;
            }
            
            if(j+1 == totalWordsLength){
                result.add(i);
            }   
        }
    }
        return result;
    }
}
