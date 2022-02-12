class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set= new HashSet<String>();
        for(String word : wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        int level=1;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String currWord = queue.poll();
                char currArray[] = currWord.toCharArray();
                for(int j=0; j<currArray.length; j++){
                    char original = currArray[j];
                    for(char c='a'; c<='z'; c++){
                        if(currArray[j]==c)
                            continue;
                        currArray[j]=c;
                        String transformed = String.valueOf(currArray);
                        if(transformed.equals(endWord)){
                            return level+1;
                        }
                        if(set.contains(transformed)){
                            queue.add(transformed);
                            set.remove(transformed);
                        }
                    }
                 currArray[j]=original;   
                }
            }
            
            level++;
        }
        return 0;
    }
}
