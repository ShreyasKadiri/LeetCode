class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] result=new double[]{nums[0],nums[1],nums[2],nums[3]};
        return reach24(result);
    }

    public boolean reach24(double[] result) {
        if(result.length==1)
        return Math.abs(result[0]-24)<0.0001;

        for(int i=0; i<result.length; i++) {
            for (int j=i+1; j<result.length; j++) {
                double[] target= new double[result.length-1];
                for (int k=0,index=0;k<result.length;k++) {
                    if (k!=i && k!=j)
                        target[index++]=result[k];
                }

                for(double num:solve(result[i],result[j])) {
                    target[target.length-1]=num;
                    if(reach24(target))
                        return true;
                }
            }
        }

        return false;
    }

    public double[] solve(double x, double y) {
        return new double[]{x+y, x-y, y-x, x*y, x/y, y/x};
    }
}