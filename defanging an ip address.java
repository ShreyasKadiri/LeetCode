class Solution {
    public String defangIPaddr(String address) {
        StringBuilder defangedVersion = new StringBuilder("");
        for(char c : address.toCharArray()){
            if(c=='.'){
                defangedVersion.append("[.]");
            }else {
                defangedVersion.append(c);
            } 
        }
        return defangedVersion.toString();
    }
}
