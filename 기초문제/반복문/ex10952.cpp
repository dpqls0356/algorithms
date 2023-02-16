#include <iostream>
using namespace std;
int main(){
    int ans[100];
    int count =0;
    ios_base::sync_with_stdio(false);
    while(true){
        int x,y;
        cin>>x>>y;
        if(x==0&&y==0){
            for(int i = 0; i<count;i++)cout<<ans[i]<<"\n";
            return 0;
        }
        ans[count]=x+y;
        count++;
    }
}
