class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> queue = new LinkedList<>();
        boolean foundPossibleWords = false; 
        List<String> start = new ArrayList<>(); 
        start.add(beginWord);
        queue.offer(start); 
        Set<String> set = new HashSet<>(wordList); 
        List<List<String>> result = new ArrayList<>(); 
        if (!set.contains(endWord)){
             return result; 
        }
        while(!queue.isEmpty() && !foundPossibleWords){
            int size = queue.size(); 
            Set<String> ifContainsDuplicates = new HashSet<>();
            for(int i=0; i<size; i++){
                List<String> currentWords = queue.poll();
                char[] currentArray = currentWords.get(currentWords.size()-1).toCharArray();
                for(int j=0; j<currentArray.length; j++){
                    char currentCharacter = currentArray[j];
                    for (char c='a'; c<='z'; c++){
                        if(c == currentCharacter){
                            continue;
                        }
                        currentArray[j] = c; 
                        String newWord = new String(currentArray);
                        if(set.contains(newWord)){
                            ifContainsDuplicates.add(newWord);
                            List<String> possibleWords = new ArrayList<>(currentWords);
                            possibleWords.add(newWord);
                            if(newWord.equals(endWord)){
                                result.add(possibleWords);
                                foundPossibleWords = true; 
                            }else{
                                queue.offer(possibleWords); 
                            }
                        }
                    }
                    currentArray[j]  = currentCharacter;
                }
            }
            for(String word : ifContainsDuplicates){
                set.remove(word); 
            }
        }
        return result; 
    }
}
