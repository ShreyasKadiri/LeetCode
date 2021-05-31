class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new List<>();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        Arrays.sort(products);
        
        List<String> listOfProducts = Arrays.asList(products);
        for(int i=0; i<listOfProducts.length(); i++){
            map.put(listOfProducts, i);
        }
        
        String prefix = "";
        for(char c : searchWord.toCharArray()){
            prefix+=c;
            String high = map.ceilingKey(key);
            String low = map.floorKey(key + "{");
            
            if(top == null || low == null){
                break;
            }
            result.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling)+3, map.get(floor)+1)));
        }
         while (ans.size() < searchWord.length()){
             ans.add(new ArrayList<>());
         }
        return result;
    }
}
