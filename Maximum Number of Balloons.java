class Solution {
    public int maxNumberOfBalloons(String text) {
        int minimumOccurence = 0;
        int frequencyCount[] = new int[26];
       for(int i=0; i<text.length(); i++){
          frequencyCount[text.charAt(i) - 'a']++;
       } 
        minimumOccurence =frequencyCount[1];
        minimumOccurence = Math.min(minimumOccurence, frequencyCount[1]); //character b
        minimumOccurence = Math.min(minimumOccurence, frequencyCount[0]); //character a
        minimumOccurence = Math.min(minimumOccurence,frequencyCount[11] / 2); //character 'l' as "balloon" has 2 occurences of l
        minimumOccurence = Math.min(minimumOccurence,frequencyCount[14] /2); //character o as "balloon" has 2 occurences of o
        minimumOccurence = Math.min(minimumOccurence, frequencyCount[13]); //character n
        
        return minimumOccurence;
    }
}
