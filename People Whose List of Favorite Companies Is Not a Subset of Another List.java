class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        int len=favoriteCompanies.size();
        for (int i=0; i<len; i++) {
            List<String> temp=favoriteCompanies.get(i);
            for (String comp:temp) {
                if (!map.containsKey(comp)) 
                    map.put(comp, new ArrayList<Integer>());
                    map.get(comp).add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<len; i++) {
            List<String> comps=favoriteCompanies.get(i);
            if (isValid(comps,map,len,i))
                result.add(i);
        }
        return result;
    }

    private boolean isValid(List<String> comps, Map<String, List<Integer>> map, int len, int currIndex) {
        int[] freq=new int[len];
        for (String comp:comps) {
            List<Integer> list=map.get(comp);
            for (Integer index:list)
                freq[index]++;
        }
        for (int i=0; i<freq.length; i++) {
            if (freq[i]==comps.size() && i!=currIndex) 
                return false;
        }
        return true;
    }
}