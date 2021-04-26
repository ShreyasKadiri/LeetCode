class Solution {
    public String sortString(String s) {
        int[] frequency = new int[26];
        for (int i=0; i<s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder(s.length());
        int count = 0;
        while (count < s.length()) {
            for (int i=0; i<26; i++) {
                if (frequency[i] > 0) {
                    result.append((char) (i + 'a'));
                    frequency[i] = frequency[i] - 1;
                    count++;
                }
            }
            for (int i=25; i>=0; i--) {
                if (frequency[i] > 0) {
                    result.append((char) (i + 'a'));
                    frequency[i] = frequency[i] - 1;
                    count++;
                }
            }
        }
        return result.toString();
    }
}
