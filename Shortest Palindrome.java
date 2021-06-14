class Solution {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        String temp = s +"#" + reverse;
        int table[] = new int[temp.length()+1];
        
        for(int i=1; i<temp.length(); i++){
            int j = table[i-1];
            while(j>0 && temp.charAt(i)!=temp.charAt(j)){
                j = table[j-1];
            }
            if(temp.charAt(i) == temp.charAt(j)){
                table[i] = j + 1;
            }
        }
        return reverse.substring(0, s.length()-table[temp.length()-1])+s;
    }
}
