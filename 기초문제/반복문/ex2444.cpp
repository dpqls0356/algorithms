#include <iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    // for(int i=0;i<n;i++){
    //     for(int k=n-i-1;k>0;k--)cout<<" ";
    //     for(int j=0;j<2*i+1;j++)cout<<"*";
    //     cout<<"\n";
    // }
    // for(int a=0;a<n-1;a++){
    //     for(int b = 0;b<a+1;b++)cout<<" ";
    //     for(int c = 2*(n-a)-3;c>0;c--)cout<<"*";
    //     cout<<"\n";
    // }   
    int star = 1;
    int blank = n-1;
    int max = 2*n-1;
    for(int i=0;i<max;i++){
        for(int k=0;k<blank;k++)cout<<" ";
        for(int k=0;k<star;k++)cout<<"*";
        cout<<"\n";
        if(i<n-1){
            blank--;
            star+=2;
        }
        else{
            blank++;
            star-=2;
        }
    }
}