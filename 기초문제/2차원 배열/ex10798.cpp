#include <iostream>
using namespace std;
int main(){
    char arr[5][15]={' '};
    for(int i=0;i<5;i++){
        string str;
        cin>>str;
        for(int k=0;k<str.length();k++){
            arr[i][k]=str[k];
        }
    }
    for(int i=0;i<15;i++){
        for(int k=0;k<5;k++){
            if(int(arr[k][i])==0)continue;
            else cout<<arr[k][i];
        }
    }
}