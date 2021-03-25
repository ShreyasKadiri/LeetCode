class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<words.length-1; i++){
            String currentWord = words[i];
            for(int j=i+1; j<words.length; j++){
                String nextWord = words[j];
                
                if(currentWord.contains(nextWord)){
                    set.add(nextWord);
                }else if(nextWord.contains(currentWord)){
                    set.add(currentWord);
                }
            }   
        }
        return  new ArrayList<>(set);
    }
}
