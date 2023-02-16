#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    int count = 0;
    cin >>count;
    int ans[count];
    for(int i=0;i<count;i++){
        int x,y;
        cin>>x>>y;
        ans[i] = x+y;
    }
    for(int k=0;k<count;k++){
        cout<<ans[k]<<"\n";
    }
}