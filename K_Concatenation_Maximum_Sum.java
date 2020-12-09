class Solution {
public int kConcatenationMaxSum(int[] arr, int k) {    

//Applying Kadane's Algorithm...o(n)
int n=arr.length;
int msf=arr[0];
int meh=arr[0];
for(int i=1;i<n;i++){
meh=Math.max(meh+arr[i],arr[i]);
msf=Math.max(msf,meh);
}
        
if(k<2) 
return msf;
    
int leftSum=arr[0];
int rightSum=arr[n-1];

int lMax=Math.max(0,arr[0]);
int rMax=Math.max(0,arr[n-1]);
    
for(int i=1;i<n;i++){
leftSum+=arr[i];
lMax=Math.max(lMax,leftSum);
}
        
for(int i=n-2;i>=0;i--){
rightSum+=arr[i];
rMax=Math.max(rMax,rightSum);
}
int totalMax=lMax+rMax;
if(leftSum<0) 
return Math.max(msf,totalMax);
        
else
return Math.max(msf,(int)(totalMax+((k-2)*(long)leftSum)%1000000007));            
}
}