#include <iostream>
using namespace std;
int main(){
    int size,input;
    cin>>size>>input;
    int basket[101];
    for(int i=1;i<size+1;i++)basket[i]=i;
    for(int i=0;i<input;i++){
        int idx1,idx2;
        cin>>idx1>>idx2;
        int tmp = basket[idx1];
        basket[idx1] = basket[idx2];
        basket[idx2] = tmp;
    }
    for(int k=1;k<size+1;k++)cout<<basket[k]<<" ";
}