class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String words[] = text.split(" ");
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i=2; i<words.length; i++){
            if(first.equals(words[i-2])  && second.equals(words[i-1])){
                result.add(words[i]);
            }
        }
       return result.toArray(new String[result.size()]);
    }
}
