class Solution {
    int max=0;
    class Pair{
        int id;
        int last;
        
        public Pair(int i, int l){
            id=i;
            last=l;
        }
        @Override
        public String toString(){
            return id+ ":" +last;
        }
    }
    
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> result = new ArrayList<Integer>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>( (a,b) -> Integer.compare(a.last, b.last));
        int requestCount[] = new int[k];
        int target, time;
        for(int i=0; i<k; i++){
            treeSet.add(i);
        }
        
        for(int i=0; i<arrival.length; i++){
            target = i%k;
            time=arrival[i];
            //Get all the elements present in the priorityqueue
            while(!minHeap.isEmpty() && time>minHeap.peek().last){
                treeSet.add(minHeap.poll().id);
            }
            //If we have a target available then we will remove it from availables and add it to busy
            if(treeSet.size()>0 && treeSet.contains(target)){
                /*
                counter[target]++
                available.remove(target);
                minHeap.add(new Pair(target, available, load[i]-1));
                */
             updateServerStates(i, target, requestCount, treeSet, minHeap, load, arrival);
            }
            else if(treeSet.size()>0){
                //find next next available one
    boolean found = updateServerStates(i, treeSet.ceiling(target), requestCount, treeSet, minHeap, load, arrival);
//If we dont have the next one then we will try the first one , if we dont find this too then we will drop this request
        if(!found){
updateServerStates(i, treeSet.first(), requestCount, treeSet, minHeap, load, arrival);
        }
            }
        }
        for(int i=0; i<k; i++){
            if(requestCount[i]==max){
                result.add(i);
            }
        }
        return result;
    }
    
    
public boolean updateServerStates(int i, int target, int[] requestCount, TreeSet<Integer>treeSet, PriorityQueue<Pair>minHeap, int[] load, int[] arrival){
        if(target!=0){
            requestCount[target]++;
            treeSet.remove(target);
            minHeap.add(new Pair(target, arrival[i]+load[i]-1));
            if(requestCount[target]>max){
                max = requestCount[target];
                return true;
            }
        }
        return false;
    }

}

/*Approach:

We use a treeset to keep track of avaialable servers and a priorityqueue to keep track of busiest servers
1. Add available servers to the tree
2. For each incoming request we try to get the target server
3. Get all the available servers from priority queue
4. Check if the target is avaialble
5. If it is not available check the avaialabilty of forward elements
6. If there are no forward avaialable elements then grab the first available
7. If not back or forward the we will have to drop the request
8. If we find then we need to add to the server count
9. Return the servers that have same maximum value
*/