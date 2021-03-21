class Solution {
    public int secondHighest(String s) {
      List<Integer> result = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                int val =  c - '0';
                result.add(val);
            }
        }
        Collections.sort(result);
      
        int ans = -1;
        int i, first, second;
        int arr_size = result.size();
    
        first = second = -1;
        second =-1;
        for (i = 0; i < arr_size; i++) {
            if (result.get(i) > first) {
                second = first;
                first = result.get(i);
            }
            else if (result.get(i) > second && result.get(i) != first)
                second = result.get(i);
        }
        return second;
    }
}
