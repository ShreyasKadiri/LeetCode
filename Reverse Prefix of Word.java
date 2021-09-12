class Solution {
    public String reversePrefix(String word, char ch) {
        String result = "";
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == ch){
                result+= reverse(word.substring(0,i+1)) + word.substring(i+1);
                break;
            }
        }
        
        return result == "" ? word : result;
    }
    
    private String reverse(String s){
        int i = 0;
        int  j =s.length()-1;
        char array[] = s.toCharArray();
        while(i<=j){
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
            i++;
            j-=1;
        }
        return new String (array);
    }
}
