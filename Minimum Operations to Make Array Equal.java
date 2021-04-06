class Solution {
    public int minOperations(int n) {
        int count = n/2;
        return count*(count + n%2);
    }
}
