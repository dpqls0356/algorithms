#include <iostream>
using namespace std;
int main(){
    int size,input;
    cin>>size>>input;
    int basket[101];
    for(int i=1;i<size+1;i++)basket[i]=i;
    for(int k=0;k<input;k++){
        int start,end;
        cin>>start>>end;
        for(int j=0;j<=(end-start)/2;j++){
            int tmp = basket[j+start];
            basket[j+start] = basket[end-j];
            basket[end-j] = tmp;
        }
    }
    for(int i=1;i<size+1;i++)cout<<basket[i]<<" ";
}