//Brute Force TC: o(2^n)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0){
            return true;
        } 
        boolean flag1 = false; 
        if (s1.length() > 0 && (s1.charAt(0) == s3.charAt(0))){
            flag1 = isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        boolean flag2 = false; 
        if (!flag1 && s2.length() > 0 && (s2.charAt(0) == s3.charAt(0))){
            flag2 = isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return flag1 || flag2;
    }
}
