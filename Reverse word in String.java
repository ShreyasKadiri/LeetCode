class Solution{
public static string reverseWords(String s){
String result="";
String wordArray[] = s.split(" ");
for(int i=word.length-1; i>=0; i--){
result+=wordArray[i] + " ";
}
return result;
}
}
