class Solution{
  public static List<List<Integer>> combinationSum (int candidates[], int target){
    HashSet<List<Integer>> result = new HashSet<List<Integer>>();
     backTrack(candidates, target, startIndex, new ArrayList(), result);
  return result;
  }
  
  public static void backTrack(int candidates[], int target, int startIndex, List<Integer> currentList, Set<List<Integer>> result){
    int n= candidates.length;
    if(target<0){
    return ;}
    if(target==0){
    result.add(new ArrayList(currentList));
    }
   for(int i=0; i<n; i++){
     currentList.add(candidate[i]);
     backTrack(candidates, candidate[i]-target, i+1, currentList, result);
     currentList.remove(currentList.size()-1);
     }
   }
}
