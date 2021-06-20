class Solution {
    public int maxRepeating(String sequence, String word) {
        String foundString = "";
        while(sequence.contains(foundString)){
            foundString += word;
        } 
        return (foundString.length()-word.length())/word.length();
    }
}


//Approach 2
class Solution {
    public int maxRepeating(String sequence, String word) {
        int maximum = 0;
        for(int i=0; i<sequence.length(); i++) {
            int count = 0;
            int k = 0;
            for(int j=i; j<sequence.length(); j++) {
                if(sequence.charAt(j) == word.charAt(k)){
                    k++;
                }
                else{
                    break;
                }
                if(k == word.length()) {
                    k = 0;
                    count++;
                }
            }
            maximum = Math.max(maximum, count);
        }
        return maximum;
    }
}
