#include <iostream>
using namespace std;
int main(){
    int x;
    ios_base::sync_with_stdio(false);
    cin>>x;
    for(int i =0;i<x;i++){
        for(int j=x;j>i+1;j--)cout<<" ";
        for(int k=0;k<=i;k++)cout<<"*";
        cout<<"\n";
    }
}