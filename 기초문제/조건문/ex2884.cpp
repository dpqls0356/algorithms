#include <iostream>
using namespace std;
int main(){
    int h,m;
    cin >>h>>m;
    if(m-45<0){
        if(h-1<0)h=23;
        else h=h-1;
        m = 60-(45-m);
    }
    else m=m-45;
    cout <<h<<" "<<m;
}