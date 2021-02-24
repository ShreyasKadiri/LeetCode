public class Solution {
    String[] rows = new String[]{"QWERTYUIOPqwertyuiop","ASDFGHJKLasdfghjkl","ZXCVBNMzxcvbnm"};
        
    public String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<String>();
    
        int currentRow = 0;
        boolean found = true;
        for(String word : words){
            currentRow = getCurrentRow(word.charAt(0));
            found = true;
            for(char c: word.toCharArray()){
                if(rows[currentRow].indexOf(c) == -1){
                    found = false;
                    break;
                }
            }
            if(found)
               result.add(word);
        }
        return result.toArray(new String[result.size()]);
    }
    
    
    private int getCurrentRow(char c){
       for(int i=0; i<3; i++){
           if (rows[i].indexOf(c)!= -1){
               return i;
           }
       }
       return -1;
    }
}
