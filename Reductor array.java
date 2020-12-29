class Solution{
  public int compareValue(int a[], int b[], int d){
                int comparator = 0;
                for (int i=0; i<a.length; i++) {
                      int counter = 0;
                        for (int j=0; j<b.length; j++) {
                           if(Math.abs(a[i]-b[j]) > d)
                                counter++;
                        }
                        if(counter==b.length)
                           comparator++;
                }
                return comparator;
        }
}
