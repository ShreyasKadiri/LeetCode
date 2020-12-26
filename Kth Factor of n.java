/*
class Solution {
    public int kthFactor(int n, int k) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
            if(count==k){
                return i;
            }
        }
        return -1;
    }
}
*/

/*
class Solution{
public int kthFactor(int n, int k) {
    List<Integer> result=new ArrayList<>();
    for(int i=1; i<=n; i++){
        if(n%i==0) {
            result.add(i);
        }
    }
    if(result.size()>=k) {
        return binarySearch(result,k);
    }
    return -1;
}

public int binarySearch(List<Integer>result, int k) {
    int i=0;
    int j=result.size()-1;
    while(i<=j){
        int mid=i+(j-i)/2;
        if(mid==k-1) 
            return result.get(mid);
        if(mid>(k-1)){
            j=mid-1;
        } else {
            i=mid+1;
        }
    }
    return -1;
}
}*/


public class Solution{
   public int kthFactor(int n, int k) {
    for (int i=1; i<=n/2; i++)
        if (n%i==0 && --k==0)
            return i;
    return k==1 ? n:-1;
    }
}
