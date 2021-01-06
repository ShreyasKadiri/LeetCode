class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result= new ArrayList<String>();
        if (s.length()>12)  return result;
        dfs(s, 0, 0, "", result);
        return result;
    }
    
    public void dfs(String s, int inserted, int pos, String curr, List<String> result) {
        if (inserted==4 && pos==s.length())
            result.add(curr);
        for (int i=0; i<3; i++) {
            if (pos+i>=s.length()) break;
            String value=s.substring(pos,pos+i+1);
            if (value.charAt(0)=='0' && value.length()!=1)
                continue;
            if (Integer.parseInt(value)<=255) {
                if (inserted==0)
                    dfs(s,1,i+1,value,result);
                else
                    dfs(s, inserted+1, pos+i+1, curr+"."+value, result);
            }
                
        }
    }
}