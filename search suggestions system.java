class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        List<List<String>> result = new ArrayList<>();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        Arrays.sort(products);

        List<String> listOfProducts = Arrays.asList(products);

        for (int i=0; i<products.length; i++) {
            treeMap.put(products[i], i);
        }

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            String high = treeMap.ceilingKey(prefix);
            String low = treeMap.floorKey(prefix + "{");
            if (high == null || low == null) {
                break;
            }
            result.add(listOfProducts.subList(treeMap.get(high), Math.min(treeMap.get(high) + 3, treeMap.get(low) + 1)));
        }

        while (result.size() < searchWord.length()) {
            result.add(new ArrayList<>());
        }
        return result;
    }
}
