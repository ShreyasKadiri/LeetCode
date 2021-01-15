class Solution {
    public int[] constructRectangle(int area) {
        if(area<=0){
            return new int[]{-1,-1};
        }
        int dimension[] =  new int[2];
        int j=1; //Let j be first dimension
        int i=area; //Let i be another dimension
        while(j<=i){
            if(area%j==0) {     //Check if i*j == area 
                i=area/j;       //This is another dimension
                dimension[0] = j;
                dimension[1] = i;
            } 
            j+=1;
        }
       return dimension; 
    }
}
