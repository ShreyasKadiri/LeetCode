class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength=-1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0 ; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                maxLength=Math.max(maxLength, i-1-map.get(s.charAt(i)));
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }
}
