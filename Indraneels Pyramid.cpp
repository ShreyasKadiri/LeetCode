#include <bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define vii vector<vi>
#define pii pair<int,int>
#define vpii vector<pii>
#define f first
#define s second

int main()
{
    int m;
    cin>>m;
    vpii a(m);
    
    for (int i = 0;i<m;i++){
        cin>>a[i].f>>a[i].s;
        if (a[i].f>a[i].s)
         swap(a[i].f, a[i].s);
    }
    
    sort(a.begin(),a.end());
    
    int max=0;
    
    for (int i=0; i<m; i++){
        if(a[i].f>max)
        max++;
    }
    cout<<max;
    return 0;
}
