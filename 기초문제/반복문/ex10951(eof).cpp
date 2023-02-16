#include <iostream>
using namespace std;
int main(){
    while(true){
        int x,y;
        cin >>x>>y;
        if(cin.eof()==true)break;
        cout<<x+y<<"\n";
    }
}