class Solution {
    public static int findJudge(int N, int[][] trust) {
        if(trust.length == 0){
            if(N == 1){
                return 1;
            }else {
                return -1;
            }
        }
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for(int[] i : trust){
            set.add(i[1]);
        }
        for(int[] trusts:trust){
            for(int j=0; j<=1; j++){
                HashSet<Integer>temp;
                if(map.containsKey(trusts[0])){
                    temp=map.get(trusts[0]);
                }else {
                    temp = new HashSet<>();
                }
                temp.add(trusts[1]);
                map.put(trusts[0],temp);
                set.remove(trusts[0]);
            }
        }
        int result = -1;
        if(set.size() == 1){
            Iterator<Integer> itr = set.iterator();
            int currentElement = itr.next();
            if(map.containsKey(currentElement)){
                return -1;
            }
            for (Map.Entry<Integer, HashSet<Integer>>entry: map.entrySet()){    
                HashSet<Integer>temp=entry.getValue();
                if (!temp.contains(currentElement)){
                     return -1;
                }
            }
            result = currentElement;
        }
        return result;
    }
}
