/*
Approach:

Optimized Solution Using Binary Search
Solution idea

The idea here is to leverage the binary search algorithm in order to optimize this problem. If you have paid attention to the definition of median, you must have noticed in 
case of odd elements the median is (1+N*M)/2 th smallest number which basically implies that (1+N*M)/2 is the total number of elements which are smaller or equal to our median.
One more thing to analyse is, the median will always lie in the range of minimum and maximum element.Using these observations and applying binary search for elements in the above
range (minimum, maximum) and maintaing the counter for smaller or equal numbers for each element in this range, we can find our median(discussed above based on count of smaller 
or equal elements).

Solution idea

Let us see a step-by-step approach to this solution:

First, we need to find the minimum and maximum elements from the matrix. The minimum and maximum can be easily found since the rows are sorted so we need to comapare with the
first element of each row for minimum and last element of each row for maximum.
After finding our min and max, we can apply binary search on this range. The mid element can be calculated and number of elements smaller or equal to mid can be calculated, 
we have used upper_bound() function for this.
Based on the value of our counter, the min and max can be adjusted accordingly based on what we do for binary search.
*/
int Solution::findMedian(vector<vector<int> > &A) 
{
    int r=A.size(),c=A[0].size();
    int req=(r*c+1)/2;
    int i=0;
    
    int minm=INT_MAX,maxm=INT_MIN;
    
    for(i=0;i<r;i++)
    {
        minm=min(minm,A[i][0]);
        maxm=max(maxm,A[i][c-1]);
    }
    
    while(minm<maxm)
    {
        int mid=minm+(maxm-minm)/2;
        int place=0;
        for(int i=0;i<r;i++)
         place+=upper_bound(A[i].begin(),A[i].end(),mid)-A[i].begin();
         
        if(place<req) minm=mid+1;
        else maxm=mid;
    }
    return minm;
}
