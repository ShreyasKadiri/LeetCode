class Solution{
    public List<List<Integer>> fourSum(int a[], int target){
        List<List<Integer>> result = new ArrayList<>();
        
        if(a.length==0){
            return result;
        }
        Arrays.sort(arr);
        int left = -1;
        int right=a.length-1;
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<n; j++){
                int restTarget = target - a[i] - a[j];
                left = j+1;
                right = a.length-1;
                while(left < right){
                    int sum = a[left] + a[right];
                    if(sum < restTarget){
                        left+=1;
                    }
                    else if(sum > restTarget){
                        right-=1;
                    }
                    else {
                        List<Integer> currentQuad = new ArrayList<Integer>();
                        currentQuad.add(a[i]);
                        currentQuad.add(a[j]);
                        currentQuad.add(a[left]);
                        currentQuad.add(a[right]);
                        result.add(currentQuad);
                        
                        while(left < right && a[left]==currentQuad.get(2)){
                            ++left;
                        }
                            
                        while(left < right && a[left]==currentQuad.get(3)){
                            --right;
                        }
                    }
                    
                    while(j+1 < n && a[j+1] < a[j])
                    ++j;
                }
                while(i+1 < n && a[i+1] < a[i])
                    ++i;
            }
        }
        return result;
    }
}
