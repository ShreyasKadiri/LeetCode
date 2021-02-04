class Solution {
    public int[] deckRevealedIncreasing(int[] A) {
        //think reversely
        int res[]=new int[A.length]; 
        Arrays.sort(A);
        LinkedList<Integer>deque=new LinkedList<>();
        
        deque.add(A[A.length-1]);
        
        for(int i=A.length-2;i>=0;i--){
            int cur=A[i];
            int last=deque.removeLast();
            deque.addFirst(last);
            deque.addFirst(cur);
        }
        
        int index=0;
        while(deque.size()!=0){
            res[index++]=deque.removeFirst();
        }
        
        return res;
        
    }
}