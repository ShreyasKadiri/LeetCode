class Solution {
    public String replaceDigits(String s) {
        char characters[] = s.toCharArray();
        for (int i=1; i<s.length(); i+=2) {
            characters[i] = (char)(characters[i-1] + characters[i] - '0');
        }
        return String.valueOf(characters);
    }
}
