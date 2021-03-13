class Solution {
    public String reverseOnlyLetters(String S) {
       char charArray[] = S.toCharArray();
        int low =0;
        int high = charArray.length-1;
        
        while(low<high){
        if(!Character.isLetter(charArray[low])){ 
            low++; 
            continue;
        }
        if(!Character.isLetter(charArray[high])){ 
            high--; 
            continue;
        }
        //Swapping characters at low and high
        char swap=charArray[low];
        charArray[low]=charArray[high];
        charArray[high]=swap; 
        low++; 
        high--;
    }
    return String.valueOf(charArray);   
  }
}
