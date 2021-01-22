class Solution {
    public String reorganizeString(String S) {
        HashMap<Character,Integer> map = new  HashMap<Character,Integer>();
        for(char c: S.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1); }
        
PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        maxHeap.addAll(map.entrySet());
        Map.Entry<Character, Integer> previous=null;
        StringBuilder sb = new StringBuilder(S.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer>current=maxHeap.poll();
            if (previous!= null && previous.getValue()>0) {
                maxHeap.offer(previous);
            }
            sb.append(current.getKey());
            current.setValue(current.getValue()-1);
            previous=current;
        }
        
        return sb.toString().length()==S.length() ? sb.toString() : "";
    }
}