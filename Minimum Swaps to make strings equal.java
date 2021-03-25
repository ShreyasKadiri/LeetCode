class Solution {
    public int minimumSwap(String s1, String s2) {
        if(s1.length()!=s2.length())
            return -1;
        int count1=0;
        int count2=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='x') 
                    count1++;
                else 
                    count2++;
            }
        }
        if((count1+count2)%2==1) 
            return -1;
        int result=0;
        result+=count1/2+count2/2;
        if(count1%2==0) 
            return result;
        return result+2;
    }
}