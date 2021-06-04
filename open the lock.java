class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEnds = new HashSet<String>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<String>();
        int level = 0;
        visited.add("0000");
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String currentState = queue.poll();
                if(deadEnds.contains(currentState)){
                    size-=1;
                    continue;
                }
                if(currentState.equals(target)){
                    return level;
                }
                StringBuilder newState = new StringBuilder(currentState);
                for(int i=0; i<4; i++){
                    char currentCharacter = newState.charAt(i);
                    String firstState = newState.substring(0,i) + (currentCharacter == '9' ? '0' : currentCharacter - '0' + 1) + newState.substring(i+1);
                    String secondState = newState.substring(0,i) + (currentCharacter == '9' ? '0' : currentCharacter - '0' - 1) + newState.substring(i+1);
                    
                    if(!visited.contains(firstState) && !deadEnds.contains(firstState)){
                        queue.offer(firstState);
                        visited.add(firstState);
                    }
                    if(!visited.contains(secondState) && !deadEnds.contains(secondState)){
                        queue.offer(secondState);
                        visited.add(secondState);
                    }
                }
                size-=1;
            }
            level++;
        }
        return -1;
    }
}
