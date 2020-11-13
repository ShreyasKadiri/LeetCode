public class Solution{
public int findCelebrity(int party[][]){

if(party.length==0){
return -1; }

int X=0;
int Y=party.length-1;

while(X<=Y){
if(party[X][Y]==0){
Y-=1;
}
else if(party[X][Y]==1){
X+=1;
}
}
return X;
}
}
