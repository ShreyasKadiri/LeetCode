#include<bits/stdc++.h>
using namespace std;
#define V 5
#define pb push_back

unordered_map<int,vector<int>> adj;

void DFS(int u,vector<int>& disc,vector<int>& low,vector<int>& parent,vector<pair<int,int>>& bridge)
{
	static int time = 0;
	disc[u] = low[u] = time;
	time+=1;

	for(int v: adj[u])
	{
		if(disc[v]==-1)	//If v is not visited
		{
			parent[v] = u;
			DFS(v,disc,low,parent,bridge);
			low[u] = min(low[u],low[v]);

			if(low[v] > disc[u])
				bridge.pb({u,v});
		}
		else if(v!=parent[u])	//Ignore child to parent edge
			low[u] = min(low[u],disc[v]);
	}
}

void findBridges_Tarjan()
{
	vector<int> disc(V,-1),low(V,-1),parent(V,-1);
	vector<pair<int,int>> bridge;

	for(int i=0;i<V;++i)
		if(disc[i]==-1)
			DFS(i,disc,low,parent,bridge);

	cout<<"Bridges are: \n";
	for(auto it: bridge)
		cout<<it.first<<"-->"<<it.second<<"\n";
}
