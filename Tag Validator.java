public class Solution {

    public boolean isValid(String code) {
        if(code.length() < 2)
            return false;
        if(code.charAt(0) != '<')
            return false;
        if(code.charAt(1) == '!' || code.charAt(1) == '/')
            return false;
        Stack<String> stack  = new Stack();
        int index = 0;
        while(index < code.length()){
            if(code.charAt(index) == '<' && index == code.length()-1)
                return false;
            else if(code.charAt(index) == '<' && code.charAt(index+1) == '!'){
                index = checkCdata(code, index);
                if(index == -1)
                    return false;
            }
            else if(code.charAt(index) == '<' && code.charAt(index+1) == '/'){
                int start = index;
                index = checkEndTag(code, start);
                if(index == -1)
                    return false;
                if(stack.empty() || !stack.pop().substring(1).equals(code.substring(start+2, index)))
                    return false;
                if(stack.empty() && index != code.length())
                    return false;   
            }
            else if(code.charAt(index) == '<'){
                int start = index;
                index = checkFrontTag(code, start);
                if(index == -1)
                    return false;
                stack.push(code.substring(start, index));
            }
            else
                index++;
        }
        return stack.empty();
    }
    
    private int checkFrontTag(String code, int start){
        if(code.charAt(start) != '<')
            return -1;
        int count = 0;
        for(int i =start+1;i<code.length();i++){
            if(code.charAt(i) == '>' && (count < 1  || count >9))
                return -1;
            if(code.charAt(i) == '>')
                return (i+1);
            if(code.charAt(i) >= 65 && code.charAt(i) <= 90)
                count++;
            else
                return -1;
        }
        return -1;
    }
    
    private int checkEndTag(String code, int start){
        for(int i =start+2;i<code.length();i++){
            if(code.charAt(i) == '>')
                return (i+1);
            if(code.charAt(i) < 65 && code.charAt(i) > 90)
                return -1;
        }
        return -1;
    }
    
    private int checkCdata(String code, int start){
        int index= code.indexOf("<![CDATA[", start);
        if(index != start)
            return -1;
        index = code.indexOf("]]>", start); 
        if(index == -1)
            return index;
        else
            return index+3;
    }
}