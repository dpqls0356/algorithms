#include <iostream>
using namespace std;
int main(){
    int arr[9][9];
    for(int i=0;i<9;i++){
        for(int k=0;k<9;k++){
            cin>>arr[i][k];
        }
    }
    int bignum=arr[0][0];
    int bigrow;
    int bigcol;
        for(int i=0;i<9;i++){
        for(int k=0;k<9;k++){
            if(bignum<=arr[i][k]){
                bignum=arr[i][k];
                bigrow = i;
                bigcol = k;
            }
        }
    }
    cout<<bignum<<"\n"<<bigrow+1<<" "<<bigcol+1;
}