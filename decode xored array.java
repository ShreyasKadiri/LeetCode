class Solution {
    public int[] decode(int[] encoded, int first) {
        int original[] = new int[encoded.length+1];
        original[0] = first;
        for(int i=0; i<encoded.length; i++){
            original[i+1] = encoded[i] ^ original[i];
        }
        return original;
    }
}
