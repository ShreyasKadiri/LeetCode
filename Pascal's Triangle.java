class Solution {
    public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> result = new ArrayList<>();
        if (numRows<=0){
            return result; 
        }
        List<Integer> previousRow = new ArrayList<Integer>();
        previousRow.add(1);
        result.add(previousRow);
        
        for (int i=2; i<=numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); 
            for (int j=0; j<previousRow.size()-1; j++){
                currentRow.add(previousRow.get(j) + previousRow.get(j+1));
            }
            currentRow.add(1);
            result.add(currentRow);
            previousRow = currentRow; 
        }
        return result;
    }
}
