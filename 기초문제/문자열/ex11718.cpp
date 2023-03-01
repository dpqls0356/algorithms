#include <iostream>
using namespace std;
int main(){
    string str[100];
    for(int i=0;i<100;i++){
        getline(cin,str[i]);
        if(str[i]=="")break;
    }
    for(int k=0;k<100;k++){
        if(str[k]=="")break;
        cout<<str[k]<<"\n";
        }
}