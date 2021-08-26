class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int vacancy = 1;
        for (String node: nodes) {
            vacancy--;
            if (vacancy < 0){
                return false;
            }if (!node.equals("#"))  {
                vacancy += 2;
            }
        }
        return vacancy == 0;
    }
}
