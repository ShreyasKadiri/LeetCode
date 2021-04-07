class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length()/2;
        int count=0;    
        
         for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='A' || s.charAt(i)=='e' || s.charAt(i)=='E' || s.charAt(i)=='i' || s.charAt(i)=='I' ||
              s.charAt(i)=='o' || s.charAt(i)=='O'|| s.charAt(i)=='u' || s.charAt(i)=='U'){
                count+=1;
            }
        }
        
        for(int i=s.length()/2; i<s.length(); i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='A' || s.charAt(i)=='e' || s.charAt(i)=='E' || s.charAt(i)=='i' || s.charAt(i)=='I' ||
              s.charAt(i)=='o' || s.charAt(i)=='O'|| s.charAt(i)=='u' || s.charAt(i)=='U'){
                count-=1;
            }
        }
        if(count==0)
            return true;
        else
        return false;
    }
}
