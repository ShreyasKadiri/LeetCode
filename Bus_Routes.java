class Solution 
{
public int numBusesToDestination(int[][] routes, int S, int T) 
{
if(S==T) return 0;
HashSet<Integer>[] visited=new HashSet[routes.length]; 
for(int i=0;i<routes.length;i++){
visited[i]=new HashSet<Integer>();
for(int j:routes[i])
visited[i].add(j);
}
    
HashSet<Integer>[] routeNodes=new HashSet[routes.length];
for(int i=0;i<routes.length;i++){
routeNodes[i]=new HashSet<Integer>();
}
    
for(int i=0;i<routes.length;i++){
for(int j=i+1;j<routes.length;j++){
for(int k:visited[i]){
if(visited[j].contains(k)){
routeNodes[i].add(j);
routeNodes[j].add(i);
break;
     }
   } 
  }
}
       
Queue<Integer>queue=new LinkedList<Integer>();
boolean[] busTaken=new boolean[routes.length];
for(int i=0;i<routes.length;i++){
if(visited[i].contains(S)){
queue.add(i);
busTaken[i]=true;
    }
}
    
int count=1;
while(!queue.isEmpty()){
int size=queue.size();
            
while(size-->0)
{
int busnumber=queue.poll();
if(visited[busnumber].contains(T))
return count;
for(int i:routeNodes[busnumber]){
if(busTaken[i]==false){
System.out.println(i+" "+busnumber);
queue.add(i);
busTaken[i]=true;
    }
   }
}
 count++;
}
return -1;
    }
}