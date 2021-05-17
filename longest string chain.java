class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int result = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words){
            map.put(word, 1);
            for(int i=0; i<word.length(); i++){
                String predecessor = word.substring(0,i) + word.substring(i+1);
                if(map.containsKey(predecessor) && map.get(word) < map.get(predecessor)+1){
                    int value = map.get(predecessor) + 1;
                    map.put(word, value);
                }
            }
            result = Math.max(result, map.get(word));
        }
        return result;
    }
}
