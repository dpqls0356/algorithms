#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    string x,y;
    cin>>x>>y;
    reverse(x.begin(),x.end());
    reverse(y.begin(),y.end());
    if(x>y)cout<<x;
    else cout<<y;
}
