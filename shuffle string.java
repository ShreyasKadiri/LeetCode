class Solution {
    public String restoreString(String s, int[] indices) {
        char shuffledArray[] = new char[indices.length];
        for(int i=0; i<indices.length; i++){
           shuffledArray[indices[i]] =s.charAt(i);
        }
        return new String(shuffledArray);  
    }
}
