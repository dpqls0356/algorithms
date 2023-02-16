#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    int count = 0;
    cin >>count;
    int ans[count];
    int front[count];
    int behind[count];
    for(int i=0;i<count;i++){
        cin>>front[i]>>behind[i];
    }
    for(int k=0;k<count;k++){
        cout<<"Case #"<<k+1<<": "<<front[k]<<" + "<<behind[k]<<" = "<<front[k]+behind[k]<<"\n";
    }
}