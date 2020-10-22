class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] array=sentence.split(" ");
        int length=searchWord.length();
        for (int i=0; i<array.length; i++) {
            if (array[i].length() >= length &&
                    array[i].charAt(0) == searchWord.charAt(0)) {
                if (array[i].substring(0, length).equals(searchWord)) {
                    return i+1;
                }
            }
        }
        return -1;
    }
}
