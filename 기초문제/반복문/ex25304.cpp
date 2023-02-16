#include <iostream>
using namespace std;
int main(){
    int sum;
    int count;
    cin>>sum>>count;
    for(int i =0;i<count;i++){
        int price;
        int quantity;
        cin>>price>>quantity;
        sum-=price*quantity;
    }
    if(sum==0)cout<<"Yes";
    else cout<<"No";
}