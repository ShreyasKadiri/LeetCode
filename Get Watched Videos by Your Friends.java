class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        boolean visited[] = new boolean[friends.length];
        visited[id] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                 for(int friend : friends[queue.poll()]){
                     if(visited[friend]){
                         visited[friend] = true;
                         queue.offer(friend);
                     }
                 }
            }
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while(!queue.isEmpty()){
            for(String video : watchedVideos.get(queue.poll())){
                map.put(video, map.getOrDefault(video,0)+1);
            }
        }
        
         List<String> videosWatchedByFriends = new ArrayList<String>(map.keySet());
        videosWatchedByFriends.sort(new Comparator<String>(){
            @Override
             public int compare(String s1, String s2){
                 int frequency1 = map.get(s1);
                 int frequency2 = map.get(s2);
                 if(frequency1 == frequency2){
                     return s1.compareTo(s2);
                 }
                 return frequency1 - frequency2;
             }   
        });
        return videosWatchedByFriends;
    }
}
