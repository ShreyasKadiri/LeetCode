class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<String>();
        int input = 1;
        for(int i=0; i<target.length; i++){
            while(target[i] > input){
                operations.add("Push");
                operations.add("Pop");
                input++;
            }
            operations.add("Push");
            input++;
        }
        return operations;
    }
}
