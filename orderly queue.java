class Solution {
    public String orderlyQueue(String s, int k) {
        if(k==1){
            String result = s;
            for(int i=0; i<s.length(); ++i){
                String store = s.substring(i) + s.substring(0,i);
                if(store.compareTo(result) < 0){
                    result = store;
                }
            }
            return result;
        }else{
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            return new String(characters);
        }
    }
}
