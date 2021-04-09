class Solution {
    public String convertToTitle(int columnNumber) {
        String columnTitle = "";
        while(columnNumber!=0){
            char currentCharacter = (char)((columnNumber - 1)%26 + 65);
            columnNumber = (columnNumber - 1)/26;
            columnTitle = currentCharacter + columnTitle;
        }
        return columnTitle;
    }
}
