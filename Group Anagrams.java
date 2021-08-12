class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String word : strs){
            char characters[] = word.toCharArray();
            Arrays.sort(characters);
            String sortedWord = new String(characters);
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        result.addAll(map.values());
        return result;
    }
}
