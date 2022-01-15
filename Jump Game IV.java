class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<arr.length; i++){
            List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
			indices.add(i);
			map.put(arr[i], indices);
		}
        Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		boolean[] visited= new boolean[arr.length];
		int level = 0;
		while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int poppedIndex = queue.poll();
                if(poppedIndex == arr.length -1){
                    return level;
				}

				if(poppedIndex < 0 || poppedIndex >= arr.length || visited[poppedIndex]){
					continue;
				}

				if(poppedIndex-1 > 0 && !visited[poppedIndex-1]) {
					queue.offer(poppedIndex-1);
				}

				if(poppedIndex + 1 < arr.length && !visited[poppedIndex+1]) {
					queue.offer(poppedIndex+1);
				}
                if(map.containsKey(arr[poppedIndex])){
					for(int currentIndex : map.get(arr[poppedIndex])){
						if(currentIndex >= 0 && currentIndex < arr.length && !visited[currentIndex]){
							queue.offer(currentIndex);
						}
					}
					map.remove(arr[poppedIndex]);
                }
                visited[poppedIndex] = true;
			}
			level++;
        }
		return -1;
	}
}
