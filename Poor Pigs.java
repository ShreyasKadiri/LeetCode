class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int periods = (int)Math.ceil(1.0 * (minutesToTest/minutesToDie));
        return (int)Math.ceil(Math.log(buckets) / Math.log(periods+1));
    }
}
