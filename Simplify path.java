class Solution {
            Stack<String> stack = new Stack<String>();
    public String simplifyPath(String path) {
        String paths[] = path.split("/");
        for(String currentCharacter : paths){
            if(!stack.isEmpty() && currentCharacter.equals("..")){
                stack.pop();
    }else if(!currentCharacter.equals(".") && !currentCharacter.equals("") && !currentCharacter.equals("..")){
                stack.push(currentCharacter);
            }
        }
        
        List<String> result = new ArrayList<>(stack);
        return "/" + String.join("/",result);
    }
}
