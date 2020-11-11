#include<bits/stdc++.h>
# define ll long long int
using namespace std;

int solve(vector<vector<int> > arr){
    int start_i = 0, start_j = 0;

    map<pair<int, int>, bool > visited;
    queue<pair<int, pair<int, int> > > q;
    q.push({0, {start_i, start_j}});
    visited[{start_i, start_j}] = true;

    int xdir[] = {-1, 0, 1, 0};
    int ydir[] = {0, 1, 0, -1};
    int ans = -1;

    while(!q.empty()){
        pair<int, pair<int, int > > temp = q.front();
        q.pop();

        int steps = temp.first;
        int curr_x = temp.second.first;
        int curr_y = temp.second.second;

        if(arr[curr_x][curr_y] == 9){
            ans = steps;
            break;
        }    

        for(int i=0; i<4; i++){
            int newx = xdir[i] + curr_x;
            int newy = ydir[i] + curr_y;

            if(newx>=0 && newy>=0 && newx<arr.size() && newy<arr[0].size() && arr[newx][newy] != 0 && !visited[{newx, newy}]){
                visited[{newx, newy}] = true;
                q.push({steps+1, {newx, newy}});
            }
        }
    }
    return ans;
}
