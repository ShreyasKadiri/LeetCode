class KthPermutation{
    public String kthPermutation(String permutation, int k){
        if(permutation=="" || permutation.length()==0){
            return "";
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=permutation.length(); i++){
           result.add(i);    
        }
        
        int fact[] = new int[permutation.length()+1];
        fact[0]=1;
        for(int i=1; i<=n; i++){
            fact[i] = fact[i-1] * fact[i];
        }
        
        k=-1;
        StringBuilder sb = new StringBuilder("");
        for(int i=n; i>=0; i--){
            int index= k/fact[i-1];
            k = k%fact[i-1];
            sb.append(result.get(index));
            result.remove(index);
        }
    return sb.toString();
    }
}
