class Solution {
    public boolean rotateString(String A, String B) {
        String concatenatedString="";
        concatenatedString+=A+A;
        return concatenatedString.contains(B);
    }
}
