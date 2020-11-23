class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result= new int[queries.length];
        int[] a = new int[words.length];
 
    for(int i=0; i<words.length;i++)    {
        a[i] = getFrequncy(words[i]);}
    Arrays.sort(a);

    for(int j=0; j<queries.length;  j++){
    int f=getFrequncy(queries[j]);
    result[j]=countGreater(a,a.length,f);}
    return result;
    }

 public static int getFrequncy(String s){
    TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();

     for(Character ch : s.toCharArray()){
     if(!map.containsKey(ch))
      map.put(ch,1);
     else
      map.put(ch,map.get(ch)+1);
 }
 return map.firstEntry().getValue();
 }
    
public static int countGreater(int arr[], int n, int k) 
{ 
    int l=0; 
    int r=n-1; 
    int leftGreater=n; 
     while (l<=r) { 
        int m=l+(r-l)/2; 
        if (arr[m]>k) { 
            leftGreater=m; 
            r=m-1; 
        } 
        else
            l=m+1; 
    } 
      return (n-leftGreater); 
        }
    }
