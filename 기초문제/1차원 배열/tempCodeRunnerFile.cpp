#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int count[42]={0};
    int numarray[10];
    for(int i=0;i<10;i++){
        cin>>numarray[i];
        count[numarray[i]%42]++;
    }
    int c=0;
    for(int k=0;k<42;k++)if(count[k]==1)c++;
    cout<<"\n"<<c;
    
}