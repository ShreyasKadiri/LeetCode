class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        char[] characters = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c: characters){
            set.add(c);
        }
        for (int i=0; i<characters.length; i++) {
            char currentCharacter = characters[i];
            if (set.contains(Character.toUpperCase(currentCharacter)) && set.contains(Character.toLowerCase(currentCharacter))) {
                continue;
            }
            String firstSubstring = longestNiceSubstring(s.substring(0, i));
            String secondSubstring = longestNiceSubstring(s.substring(i+1));
            return firstSubstring.length() >= secondSubstring.length() ? firstSubstring : secondSubstring;
        }
        return s; 
    }
}
