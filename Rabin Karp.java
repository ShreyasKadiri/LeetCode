Rabin Karp
 class RabinKarp{
     public boolean rabinKarp(String text, String pattern, int q){
         if(text=="" || text.length() || pattern=="" || pattern.length()==0){
             return true;
         }
         //text > pattern
         int m =pattern.length();
         int n = needle.length();
         int patternHash = 0;
         int textHash = 0;
         int h=1;
         private static int d = 256;
         
         //To calculate h, the value of h would be "pow(d, M-1)%q" 
         for(int i=0; i<m-1; i++){
             h=(h*d)%q;
         }
         
         // Calculate the hash value of pattern and first window 
         for(int i=0; i<m; i++){
             patternHash = (d*patternHash + pattern.charAt(i))%q;
             textHash = (d*textHash + text.charAt(i))%q;
         }
         
         //Slide the pattern 
         for(int  i=0; i<=m-n; i++){
     // Check the hash values of current window of text and pattern. If the hash values match then only check for characters on by one
         if(patternHash == textHash){
             //Check for character by character
             for(int j=0; j<m; j++){
                 if(text.charAt(i+j) ! = pattern.charAt(j)){
                     break;
                 }
                 if(j==m){
                     return i;
                 }
                 if(i<=n-m){
                     textHash== (d*(textHash - text.charAt(i)*h) + text.charAt(i+m))%q; 
                    if (textHash<0) 
                        textHash= (textHash + q); 
                     }
                }
             }
         }
         return -1;
     }
 }