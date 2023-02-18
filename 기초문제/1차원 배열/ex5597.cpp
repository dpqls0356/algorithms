#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int att[30]={0};
    int count =0;
    for(int i=0;i<28;i++){
        int num;
        cin>>num;
        att[num-1]++;
    }
    for(int k=0;k<30;k++){
        if(att[k]==0){
            if(count==0||count==1)cout<<k+1<<"\n";
            count ++;
        }
    }
}