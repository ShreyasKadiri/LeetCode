class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        
        HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();
        for(char c : word1.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
        }
        
        
        HashMap<Character,Integer> map2 = new HashMap<Character,Integer>();
        for(char c : word2.toCharArray()){
            map2.put(c, map2.getOrDefault(c,0)+1);
        }
        
        //check if occurence of unique characters are same in both the maps
        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }
        
        List<Integer> wordsOneList = new ArrayList<Integer>(map1.values());
        List<Integer> wordsTwoList = new ArrayList<Integer>(map2.values());
        Collections.sort(wordsOneList);
        Collections.sort(wordsTwoList);
        
    
        return wordsOneList.equals(wordsTwoList);
    }
}
