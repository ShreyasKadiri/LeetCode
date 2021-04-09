class Solution {
    public int maxVowels(String s, int k) {
      int maxVowelLength=0;
      int i=0;
      int j=1;
      int countOfVowels = 0;
      HashSet<Character> set = new HashSet<Character>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
      while(i<j && i<s.length() && j<s.length() && i<k &&j<k){
          if(set.contains(s.charAt(i))){
              countOfVowels+=1;
          }
          i+=1;
          if(set.contains(s.charAt(j))){
              countOfVowels+=1;
          }
          j+=1;
          maxVowelLength = Math.max(maxVowelLength, countOfVowels);
      }
        return maxVowelLength;
    }
}
