class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<String>();
        boolean flag=false;
        StringBuilder sb = new StringBuilder();
        for(String comment: source) {
            for(int i=0; i<comment.length(); i++) { 
                char c1=comment.charAt(i);
                char c2=(i==comment.length()-1) ? '"' : comment.charAt(i+1); 
                if(flag && c1=='*' && c2=='/') { 
                    flag=false;
                    i++; 
                }
                  else if(flag) 
                    continue;
                else if(c1=='/' && c2=='*') {
                    flag=true;
                    i++; 
                }
                else if(c1=='/' && c2=='/') 
                    break; 
                else sb.append(c1);
            }
            
            if (!flag && sb.length()!=0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }
}