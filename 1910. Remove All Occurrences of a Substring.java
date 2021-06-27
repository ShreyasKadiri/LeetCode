class Solution {
    public String removeOccurrences(String s, String p) {
        return s.contains(part) ? removeOccurrences(s.replaceAll(part, ""), part) : s;
    }
}




class Solution {
    public String removeOccurrences(String s, String part) {
	        StringBuilder sb = new StringBuilder(s);
	        while(true){
	            if(sb.indexOf(part)<0){
                    break;
                }
	            int index = sb.indexOf(part);
	            sb.delete(index, index+part.length());
	        }
	        return sb.toString();
    }
}



class Solution {
  public String removeOccurrences(String s, String part) {
    Stack < Character > stack = new Stack < Character > ();
    for (int i = 0; i < s.length(); i++) {
      stack.add(s.charAt(i));
      if (stack.size() >= part.length()) {
        String l = "";
        for (int j = part.length() - 1; j >= 0; j--) {
          if (part.charAt(j) != stack.peek()) {
            int f = 0;
            while (f != l.length()) {
              stack.add(l.charAt(f));
              f++;
            }
            break;
          } else {
            l = stack.peek() + l;
            stack.pop();
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.peek());
      stack.pop();
    }
    sb.reverse();
    return sb.toString();
  }
}
