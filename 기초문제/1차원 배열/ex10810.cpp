#include <iostream>
using namespace std;
int main(){
    int size,input;
    cin >> size >> input;
    // int basket[100];
    int *basket = new int(size);
    fill_n(basket,size,0);
    for(int i=0;i<input;i++){
        int start,end,num;
        cin>>start>>end>>num;
        for(int k=start;k<=end;k++){
            basket[k-1]=num;
        }
    }
    for(int j=0;j<size;j++){
        cout<<basket[j]<<" ";
    }
    delete basket;
}
// 틀린 이유 : 배열 범위 가변으로 했다고 ;;;