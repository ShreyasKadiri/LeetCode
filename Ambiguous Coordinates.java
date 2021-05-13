class Solution {
    public List<String> ambiguousCoordinates(String s) {
        String string = s.substring(1, s.length() - 1);
        ArrayList<String> result = new ArrayList<String>();
        for (int i=1; i<s.length(); i++) {
            List<String> first = findValidCombinations(string.substring(0, i));
            List<String> second = findValidCombinations(string.substring(i));
            for (String firstString : first) {
                for (String secondString : second) {
                    result.add("(" + firstString + ", " + secondString + ")");
                }
            }
        }
        return result;
    }
    
    private List<String> findValidCombinations(String string) {
        char[] charArray = string.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        if (charArray[0] == '0' && charArray[string.length() - 1] == '0') { 
            if (string.length() == 1) {
                result.add("0");
            }
            return result;
        }
        
        if (charArray[0] == '0') { 
            result.add("0." + string.substring(1));
            return result;
        }
        if (charArray[string.length() - 1] == '0') { 
            result.add(string);
            return result;
        }
        result.add(string); 
        for (int i=1; i<string.length(); i++) { 
            result.add(string.substring(0, i) + '.' + string.substring(i));
        }
        return result;
    }
}
