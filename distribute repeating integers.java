class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        int idx = 0;
        int[] arrCounts = new int[counts.size()];
        for (var key : counts.keySet()) {
            arrCounts[idx++] = counts.get(key);
        }
        return solve(arrCounts, quantity);
    }
    
    private boolean solve(int[] counts, int[] quantity) {
        Arrays.sort(counts);
        Arrays.sort(quantity);
        reverse(quantity);
        return solve(counts, quantity, 0);
    }
    
    private void reverse(int[] arr) {
        for (int i = 0; i + i < arr.length; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
    }
    
    private boolean solve(int[] counts, int[] quantity, int idx) {
        if (idx >= quantity.length) {
            return true;
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= quantity[idx]) {
                counts[i] -= quantity[idx];
                if (solve(counts, quantity, idx + 1)) {
                    return true;
                }
                counts[i] += quantity[idx];
            }
        }
        
        return false;
    }
}
