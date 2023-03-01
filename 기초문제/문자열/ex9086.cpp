#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int test;
    cin>>test;
    string str[10];
    for(int i=0;i<test;i++){
        cin>>str[i];
    }
    for(int k=0;k<test;k++){
        string printstr = str[k];
        cout<<printstr[0]<<printstr[printstr.length()-1]<<"\n";
    }
}