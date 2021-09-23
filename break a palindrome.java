class Solution {
    public String breakPalindrome(String palindrome) {
        char characters[] =  palindrome.toCharArray();
        if(characters.length < 2){
            return "";
        }
        for(int i=0; i<characters.length/2; i++){
            if(characters[i] != 'a'){
                characters[i] = 'a';
                return new String(characters);
            }
        }
        //Place 'b' at the last position
        characters[characters.length-1] = 'b';
        return new String(characters);
    }
}
