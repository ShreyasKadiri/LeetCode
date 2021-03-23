class Solution {
      public int minOperations(String[] logs) {
        int result = 0;
        for (String log : logs) {
            if (log.equals("../")){
              result = Math.max(0, --result);  
            } 
            else if (log.equals("./")){
              continue;  
            } 
            else {
                result++;
        }
    }
        return result;
    }
}
