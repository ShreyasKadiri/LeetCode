class Solution {
    public String generateTheString(int n) {
        char generateString[] = new char[n];
        Arrays.fill(generateString, 'p');
        if(n%2 == 0){
            generateString[0] ='x';
        }
        return new String(generateString);
    }
}
