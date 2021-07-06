class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> frequencies = new ArrayList<Integer>(map.values());
        Collections.sort(frequencies, Collections.reverseOrder());

        int count = 0;
        int currentSize = arr.length;
        int i = 0;
        while(currentSize > arr.length/2){
            currentSize = currentSize - frequencies.get(i);
            i++;
            count++;
        }
        return count;
    }
}
