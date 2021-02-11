class Solution {
    public boolean isAnagram(String s, String t) {
        char firstWord[] = s.toCharArray();
        char secondWord[] = t.toCharArray();
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);
        
        String firstString = new String(firstWord);
        String secondString = new String(secondWord);

        return firstString.equals(secondString);   
    }
}
