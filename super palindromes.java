class Solution {
    public int superpalindromesInRange(String left, String right) {
        int count = 0;
        int low = Integer.parseInt(left);
        int high = Integer.parseInt(right);
        for(int i=low; i<=high; i++){
            if(checkPalindrome(i) && checkPalindrome(Math.sqrt(i))){
                    count++;
            }
        }
        return count;
    }
       
    public boolean checkPalindrome(double n){
        double temp=n;
        double reverse = 0;
        double remainder = 0;
        while(n > 0){
            reverse = (reverse*10) + n%10;    
            n = n / 10;    
        }
        return reverse == temp;
    }
}
