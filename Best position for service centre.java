//Idea: Quaternary Search
class Solution {
    public double getMinDistSum(int[][] positions) {
        double x=0.0;
        double y=0.0;
        int n=positions.length;
        
        //initially we will find center to optimise search space
        for(int[] position:positions){
            x+=position[0];
            y+=position[1];
        }
        
        x=x/n;
        y=y/n;
      
        /*We will divide our search into two parts. The first search goes from larger step 1e-3 for higher       convergence rate and next search with smaller step 1e-7 to reach the required percision*/
        
        double[] iter1=getMinDistSumByStep(x,y,1e-3,positions);
        double[] iter2=getMinDistSumByStep(iter1[0],iter1[1],1e-7,positions);
        return iter2[2];
    }
    
   
    double[] getMinDistSumByStep(double x, double y, double step, int[][] positions){
        double nstep=-1*step;
        double dist=findDistance(x,y,positions);
        double[][] directions=new double[][]{{step, step}, {step, nstep}, {nstep, step}, {nstep, nstep}};
       
        while(true)
        {
            double[] result=new double[4];
            double minimum=Integer.MAX_VALUE;
            int minIndex=-1;
            for(int i=0; i<4; i++){
                double[] direction=directions[i];
                double nextX=x+direction[0];
                double nextY=y+direction[1];
                double nextDist=findDistance(nextX, nextY, positions);
                if(nextDist<minimum)
                {
                    minimum=nextDist;
                    minIndex=i;
                }
            }
            if(minimum>=dist){
                break;
            }
            
            dist=minimum;
            x+=directions[minIndex][0];
            y+=directions[minIndex][1];
        }    
        return new double[]{x,y,dist};
    }
    
   public double findDistance(double x, double y, int[][] positions){
        double result=0.0;
        for(int[] position:positions){
            result+=distance(x,y,position[0],position[1]);}
        return result;
    }
    
   public double distance(double x, double y, double xx, double yy){
        return Math.sqrt(Math.pow(x-xx, 2) + Math.pow(y-yy, 2));
    }
}