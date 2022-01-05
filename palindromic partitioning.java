class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if(s.equals("")){
            result.add(new ArrayList());
            return result;
        }
        findAllSubstrings(s, new ArrayList()); 
        
        
        if(isPalindromeAlready(s)){
            List<String> temp = new ArrayList();
            temp.add(s);
            result.add(temp);
        }
                    
       return result;
     } 
    
    void findAllSubstrings(String s, ArrayList<String> temp){
        for(int k=1; k<s.length(); k++){
            String left = s.substring(0, k);    
            //To optimise left recurive call further than normal dp 
            if( isPalindromeAlready(left) ){
                temp.add(left);
            //To optimise right recurive call further than normal dp 
                String right = s.substring(k, s.length());  
                if( isPalindromeAlready(right)){
                    temp.add(right);    
                    result.add(new ArrayList(temp));
                    temp.remove(temp.size()-1);
                }
                findAllSubstrings(right, temp);
                temp.remove(temp.size()-1);
            } 
        }    
    }
	
    boolean isPalindromeAlready(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if( s.charAt(i) != s.charAt(j) )
                return false;
            i++; 
            j--;
        }
        return true;
    }
}
