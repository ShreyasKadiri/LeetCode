class Solution {
  public int numDifferentIntegers(String input) {
        String[] words = input.split("\\D");
        HashSet<String> set = new HashSet<String>();
        for(String word : words){
            word=word.trim();
            if(!word.equals("")){
                word = word.replaceAll("^0*","");
                set.add(word);
            }
        }
        return set.size();
    }
}
