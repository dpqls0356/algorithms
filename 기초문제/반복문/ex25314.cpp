#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    n = n/4;
    while(n!=0){
        cout<<"long ";
        n-=1;
    }
    cout<<"int";
}