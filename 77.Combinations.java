class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombinations(n, k, 0, new ArrayList<>());
        return result;
    }
    
    void findCombinations(int n, int k, int index, List<Integer>currentCombination){
        if(currentCombination.size() == k){
            result.add(new ArrayList<>(currentCombination));
        }
        for(int i=index+1; i<=n; i++){
            currentCombination.add(i);
            findCombinations(n, k, i, currentCombination);
            currentCombination.remove(currentCombination.size()-1);
        }
    }
}
