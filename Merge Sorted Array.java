class Solution 
{
    
public void merge(int[] nums1, int m, int[] nums2, int n) 
{
//For the 1st array
int merged[] = new int[m+n];
    
for(int i=0; i<m ;i++){
merged[i]=nums1[i];}
    
//For the second array
for(int i=0; i<n ;i++){
merged[m]=nums2[i];    
m++;
}
    
//To print the numbers
    for(int i=0;i<m+n;i++){
        System.out.print(merged[i]+",");
    }   
}
}
