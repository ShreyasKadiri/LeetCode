class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int el : arr)
            treeMap.put(el, treeMap.getOrDefault(el, 0) + 1);

        for (int el : treeMap.keySet()) {
            if(treeMap.getOrDefault(el, 0)>0) {
                int target = el < 0 ? el / 2 : el * 2;
                // odd check
                if (el < 0 && el % 2 != 0) {
                    return false;
                }

                if(treeMap.get(el) > treeMap.getOrDefault(target, 0)){
                    return false;
                }
                treeMap.put(target, treeMap.get(target) - treeMap.get(el));
            }
        }
        return true;
    }
}
