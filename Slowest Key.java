class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = ' ';
        int maximumDifference = Integer.MIN_VALUE;
        for (int i=0; i<keysPressed.length(); i++) {
            char currentCharacter = keysPressed.charAt(i);
            int previousPressedTime = i > 0 ? releaseTimes[i - 1] : 0;
            int difference = releaseTimes[i] - previousPressedTime;

            if (difference>maximumDifference || (difference==maximumDifference && currentCharacter>result)) {
                result = currentCharacter;
                maximumDifference = difference;
            }
        }
        return result;
    }
}
