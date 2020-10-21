class Solution {
  public String makeLargestSpecial(String S) {
        int count=0;
        int i=0;
        ArrayList<String> result = new ArrayList<String>();
        for (int j=0; j<S.length(); j++) {
          if (S.charAt(j)=='1') 
              count++;
          else 
              count--;
          if (count==0) {
            result.add('1' + makeLargestSpecial(S.substring(i+1, j)) + '0');
            i=j+1;
          }
        }
      
        Collections.sort(result, Collections.reverseOrder());
        return String.join("",result);
    }
}
    

/*Procedure
1. Split S into several special strings (as many as possible).
2. Special string starts with 1 and ends with 0. Recursion on the middle part.
3. Sort all special strings in lexicographically largest order.
4. Join and output all strings.

*/