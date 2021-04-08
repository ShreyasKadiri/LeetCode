class Solution{
    public List<String> letterCombinations(String s) {
    HashMap<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('2',new char[]{'a','b','c'});
    map.put('3',new char[]{'d','e','f'});
    map.put('4',new char[]{'g','h','i'});
    map.put('5',new char[]{'j','k','l'});
    map.put('6',new char[]{'m','n','o'});
    map.put('7',new char[]{'p','q','r','s'});
    map.put('8',new char[]{'t','u','v'});
    map.put('9',new char[]{'w','x','y','z'});
 
    List<String> result = new ArrayList<String>();
    if(s==null||s.length()==0){
        return result;
    }
 
    char[] digits = new char[s.length()];
    findCombinations(s, 0, map, result, digits);
 
    return result;
}
 
private void findCombinations(String s, int index, HashMap<Character, char[]> map, 
                        List<String> result, char[] digits){
    if(index==s.length()){
        result.add(new String(digits));
        return;
    }
 
    char currentDigit = s.charAt(index);
    char[] mappings = map.get(currentDigit);
    
    for(int i=0; i<mappings.length; i++){
        digits[index]=mappings[i];
        findCombinations(s, index+1, map, result, digits);
    }
  }
}
