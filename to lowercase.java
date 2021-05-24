//1st approach:
class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
 
//2nd approach using ASCII
class Solution {
    public String toLowerCase(String s) {
        String lowerCase = "";
        for(char c : s.toCharArray()){
            if(c >='A' && c <= 'Z'){
                lowerCase+=(char)( c + 32);
            }else {
                lowerCase+=c;
            }
        }
        return lowerCase;
    }
}
