class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char characters[] = s.toCharArray();
        int shift = 0;
        for(int i=s.length()-1; i>=0; i--){
            shift = (shift + shifts[i]) % 26;
            characters[i] = (char)((characters[i] - 'a' + shift) % 26 + 'a');
            
        }
        return new String(characters);
    }
}
