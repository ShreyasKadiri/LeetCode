class Solution{

  public List<List<Integer>> combinations (int n, int k){
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  backTrack(n,k, 1, new ArrayList(), result);
  return result;
  }
  
  public void backTrack(int n, int k, int start, List<Integer> currentList, List<List<Integer>> result){
   if(currentList.size()==k){
     result.add(currentList);
     return ;
   }
    for(int i=1; i<=n; i++){
     currentList.add(i);
     backTrack(n, k , start+1, currentList, result);
       currentList.remove(currentList.size()-1);
       }
    }
}
