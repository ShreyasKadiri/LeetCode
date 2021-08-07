public class Solution {
    public static int minCut(String s) {
        boolean palindrome[][] = new boolean[s.length()][s.length()]; 
        
        for (int i=0; i<s.length(); i++) {
            palindrome[i][i] = true;
		  }
		  

		  for (int i=0; i<s.length()-1; i++) {
              if (s.charAt(i) == s.charAt(i+1)) {
                  palindrome[i][i+1] = true;
              }
		  }
		  

		  for (int currentLength=3; currentLength<=s.length(); currentLength++){
              for (int i=0; i<s.length()-currentLength+1; i++) {
                  int j = i + currentLength-1;
                  if (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]){
                      palindrome[i][j] = true;
                  }
              }
          }
        int[] cuts = new int[s.length()];
		for(int i=0; i<s.length(); i++){
            int currentValue = Integer.MAX_VALUE;
            if(palindrome[0][i]){
                cuts[i] = 0;
            }else{
				  for(int j=0; j<i; j++){
                      if((palindrome[j+1][i]) && currentValue > cuts[j]+1){
                          currentValue = cuts[j] + 1;
                      }
                  }
                cuts[i] = currentValue;
            }
        }
        return cuts[s.length()-1];
    }
}
