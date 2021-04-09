class Solution {
    public boolean isAlienSorted(String[] word, String order) {
       HashMap<Character,Integer> map=new HashMap<>();
        int k=0;
        for(char c: order.toCharArray()){
            map.put(c,k++);
        }
        int j,f=0;
        for(int i=0;i+1<word.length;i++){
            String curr=word[i];
            String next=word[i+1];
            f=0;
            for(j=0;j<Math.min(curr.length(),next.length());j++)
            {      char c1=curr.charAt(j);
                    char c2=next.charAt(j);
               
                if(c1!=c2){
                    f=1;         //when init length is greater then next word
                  
                    if(map.get(c2)<map.get(c1)){
                        return false;
                    }
                    break;
                    
                }
            }
            if(f==0&&curr.length()>next.length()) return false;   
        }
        return true;
    }
}
