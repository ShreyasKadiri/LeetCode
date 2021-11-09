class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
        for(int i=0; i<26; i++){
            map.put((char) ('a' + i), new ArrayList<>());
        }
        for(String word : words){
            int mask = 0;
            for(char c: word.toCharArray()){
                int bit = c - 'a';
                mask = mask | (1<<bit);
            }
            HashSet<Character> set = new HashSet<Character>();
            for(char c : word.toCharArray()){
                if(set.contains(c)){
                    continue;
                }
                set.add(c);
                map.get(c).add(mask);
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String puzzle : puzzles){
            int puzzleMask = 0;
            for(char c: puzzle.toCharArray()){
                int bit = c - 'a';
                puzzleMask = puzzleMask | (1<<bit);
            }
            char firstCharacter = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = map.get(firstCharacter);
            int count=0;
            for(int wordMask : wordsToCheck){
                if((wordMask & puzzleMask) == wordMask){
                    count+=1;
                }
            }
            result.add(count);
        }
        return result;
    }
}
