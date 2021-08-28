class Solution {
    
    class Job{
        int startTiming;
        int endTiming;
        int profit;
        public Job(int startTiming, int endTiming, int profit){
            this.startTiming = startTiming;
            this.endTiming = endTiming;
            this.profit = profit;
        }
    }
    
    class Pair{ 
        int endTiming;
        int profit;
        
        public Pair(int endTiming, int profit){
            this.endTiming = endTiming;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs=new ArrayList<>();
        
        for(int i=0; i<profit.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        //sorting jobs based on start time
        Collections.sort(jobs, (a, b)->{
           return a.startTiming - b.startTiming; 
        });
        
        //making prirority que based on the end time of the job
        PriorityQueue<Pair> heap =new PriorityQueue<>((a,b)->{
           return a.endTiming - b.endTiming; 
        });
        int maximumProfit = 0;
        for(int i=0; i<profit.length; i++){
            // for a particular job we find in the priority que all the possible combination to find the max profit for this job
            while(heap.size()>0 && heap.peek().endTiming <= jobs.get(i).startTiming){
                maximumProfit = Math.max(maximumProfit, heap.peek().profit);
                heap.poll();
            }
            heap.add(new Pair(jobs.get(i).endTiming, jobs.get(i).profit + maximumProfit));
        }
        maximumProfit = 0;
        while(heap.size()!=0){
            maximumProfit = Math.max(maximumProfit, heap.poll().profit);
        }
        return maximumProfit;
        
    }
}
