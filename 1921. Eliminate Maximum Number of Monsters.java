class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int i = 0;
        for(i=0; i<dist.length; i++){
            dist[i] = (int) Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(dist);
        for(i=0; i<dist.length && dist[i]>i; i++);
        return i;
    }
}
