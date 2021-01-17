class Solution {
    public int longestDecomposition(String text) {
        if(text=="" || text.length()==0){
            return -1;
        }
        int count=0;
        int low = 0;
        int high = text.length()-1;
        long hashOne = 0;
        long hashTwo = 0;
        long baseOne=26;
        long baseTwo=1;
        
        while(low <= high){
            char c1= text.charAt(low);
            char c2 = text.charAt(high);
            hashOne = hashOne * baseOne + (c1 - 'a' +1);
            hashTwo = hashTwo + baseTwo * (c2 - 'a' +1);
            baseTwo*=baseOne;
            
            if(hashOne==hashTwo){
                if(low==high){
                    count+=1;
                }else {
                    count+=2;
                }
                hashOne=0;
                hashTwo=0;
                baseTwo=1;
            }
            low++;
            high--;
        }
        if(hashOne!=0){
            count++;
        }
        return count;
    }
}

/*
https://leetcode.com/problems/longest-chunked-palindrome-decomposition/discuss/350711/Close-to-O(n)-Python-Rabin-Karp-Algorithm-with-two-pointer-technique-with-explanation-(~40ms)

*/
