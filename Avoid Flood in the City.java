class Solution {
    public int[] avoidFlood(int[] rains) {
        int result[] = new int[rains.length];
       if(rains.length==0 || rains==null) return result;
        TreeSet<Integer> emptyLakes = new TreeSet<Integer>();
        HashMap<Integer,Integer> fullLakes = new HashMap<Integer,Integer>();
        Arrays.fill(result,1);
        for(int i=0;i<rains.length;i++){
            int lake=rains[i];
            if(lake>0){
                result[i]=-1;
                if(fullLakes.containsKey(lake)){
                    Integer emptyDay=emptyLakes.higher(fullLakes.get(lake));
                    if(emptyDay==null)
                        return new int[0];
                    result[emptyDay]=lake;
                    emptyLakes.remove(emptyDay);
                }
                fullLakes.put(lake,i);
            }
            else{
                emptyLakes.add(i);
            }
        }
        return result;
    }
}