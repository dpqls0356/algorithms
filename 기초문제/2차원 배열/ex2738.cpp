#include <iostream>
using namespace std;
int main(){
    int n,m;
    cin>>n>>m;
    int arr1[n][m];
    int arr2[n][m];
    for(int i=0;i<n;i++){
        for(int k=0;k<m;k++){
            cin>>arr1[i][k];
        }
    }
    for(int i=0;i<n;i++){
        for(int k=0;k<m;k++){
            cin>>arr2[i][k];
        }
    }
    for(int i=0;i<n;i++){
        for(int k=0;k<m;k++){
            cout<<arr1[i][k]+arr2[i][k]<<" ";
        }
        cout<<"\n";
    }
    
}