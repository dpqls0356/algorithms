#include <iostream>
using namespace std;

int main(){
    int a,b,c;
    int money;
    cin>>a>>b>>c;
    if(a==b){
        if(b==c)money = 10000+a*1000;
        else money = 1000+100*a;
    }
    else if(a!=b){
        if(b==c)money = 1000+100*b;
        else if(a==c)money = 1000+100*a;
        else{
            if(a>b&&a>c)money=100*a;
            else if(b>a&&b>c)money=100*b;
            else money=100*c;
        }
    }
    cout <<money;
}